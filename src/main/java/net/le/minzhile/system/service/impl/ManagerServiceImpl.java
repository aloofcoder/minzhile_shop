package net.le.minzhile.system.service.impl;

import net.le.minzhile.exception.AppServiceException;
import net.le.minzhile.system.dao.ManagerDao;
import net.le.minzhile.system.entity.Manager;
import net.le.minzhile.system.service.ManagerService;
import net.le.minzhile.util.PwdUtils;
import net.le.minzhile.web.PageObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Author hanle
 * @Date 2019/1/9 22:10
 * @E-mail hanl1946@163.com
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    @Value("${minzhile.page-size}")
    private Integer pageSize;

    @Resource
    private ManagerDao managerDao;

    @Override
    public Map<String, Object> findAllManager(Integer currentPage,
                                              String managerNum,
                                              String managerName,
                                              String managerMobile) {
        System.out.println(managerNum + ", " + managerName + ", " + managerMobile + "param");
        int startIndex = (currentPage - 1) * pageSize;
        List<Manager> managers = managerDao.findAllManager(startIndex, pageSize, managerNum, managerName, managerMobile);
        int count = managerDao.getRowCount(managerNum, managerName, managerMobile);
        PageObject pageObject = new PageObject(currentPage, pageSize, count, PageObject.getTotalPage(count, pageSize));
        Map<String, Object> map = new HashMap<>();
        map.put("pageObject", pageObject);
        map.put("list", managers);
        return map;
    }

    /**
     * 保存管理员
     * @param manager 管理员信息
     * @return
     */
    @Override
    public int saveManager(Manager manager){
        if(manager == null) {
            throw new AppServiceException("管理员信息不能为空！");
        }
        String managerNum = manager.getManagerNum();
        if (managerNum == null) {
            throw new AppServiceException("添加管理员信息失败，管理员账号不能为空！");
        }
        // 验证登录账号是否已经存在
        List<Manager> managers = managerDao.findManagerInfoByManagerNum(managerNum);
        if (managers.size() > 0) {
            throw new AppServiceException("添加管理员信息失败，您输入的管理员账号已被注册！");
        }
        String managerPwd = manager.getManagerPwd();
        if(managerPwd == null) {
            throw new AppServiceException("添加管理员信息失败，管理员密码不能为空！");
        }
        // 获取加密盐值
        String uuid = UUID.randomUUID().toString();
        String salt = Base64.getEncoder().encodeToString(uuid.getBytes());
        String saltPwd = PwdUtils.createSaltPwd(managerPwd, salt);
        // 设置加密后的密码
        manager.setManagerPwd(saltPwd);
        manager.setSalt(salt);
        int count = managerDao.saveManager(manager);
        if(count == -1) {
            throw new AppServiceException("系统错误，保存管理员信息失败！");
        }
        return count;
    }

    /**
     * 修改管理员信息
     * @param manager
     * @return
     */
    @Override
    public int editManager(Manager manager) {
        if(manager == null) {
            throw new AppServiceException("修改管理员信息失败，管理员账号不能为空！");
        }
        int count = managerDao.editManager(manager);
        if (count == -1) {
            throw new AppServiceException("修改管理员信息失败！");
        }
        return count;
    }

    /**
     * 通过管理员id删除管理员
     * @param id
     * @return
     */
    @Override
    public int removeManager(Integer id) {
        if (id == null || id <= 0) {
            throw new AppServiceException("删除管理员信息失败，ID错误！");
        }
        int count = managerDao.removeManager(id);
        if (count == -1) {
            throw new AppServiceException("删除管理员信息失败！");
        }
        return count;
    }

    @Override
    public void batchRemoveManager(String ids) {
        String[] idArr = null;
        try {
             idArr = ids.split(",");
        } catch (RuntimeException e) {
            throw new AppServiceException("批量删除管理员信息失败，管理员信息不合法！");
        }
        if (idArr.length <= 0) {
            throw new AppServiceException("批量删除管理员信息失败，管理员信息不能为空！");
        }
        for (int i = 0; i < idArr.length; i ++) {
            managerDao.removeManager(Integer.parseInt(idArr[i]));
        }
    }

}
