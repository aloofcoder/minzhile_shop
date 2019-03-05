package net.le.minzhile.system.service.impl;

import net.le.minzhile.exception.AppServiceException;
import net.le.minzhile.system.dao.RoleDao;
import net.le.minzhile.system.entity.Role;
import net.le.minzhile.system.service.RoleService;
import net.le.minzhile.web.PageObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author hanle
 * @Date 2019/2/26 21:40
 * @E-mail hanl1946@163.com
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Value("${minzhile.page-size}")
    private Integer pageSize;

    @Resource
    private RoleDao roleDao;

    /**
     * 分页查询角色信息
     * @param currentPage
     * @param roleName
     * @return
     */
    @Override
    public Map<String, Object> findAllRole(Integer currentPage, String roleName) {
        int startIndex = (currentPage - 1) * pageSize;
        List<Role> roles = roleDao.findAllRole(startIndex, pageSize, roleName);
        int count = roleDao.getRowCount(roleName);
        PageObject pageObject = new PageObject(currentPage, pageSize, count, PageObject.getTotalPage(count, pageSize));
        Map<String, Object> map = new HashMap<>();
        map.put("pageObject", pageObject);
        map.put("list", roles);
        return map;
    }

    @Override
    public int saveRole(Role role) {
        if (role == null) {
            throw new AppServiceException("角色信息不能为空！");
        }
        String roleName = role.getRoleName();
        if (roleName == null) {
            throw new AppServiceException("添加角色失败，角色名称不能为空！");
        }
        int count = roleDao.saveRole(role);
        if (count == -1) {
            throw new AppServiceException("添加角色信息失败，服务异常！");
        }
        return count;
    }

    @Override
    public int editRole(Role role) {
        if (role == null) {
            throw new AppServiceException("修改角色失败，角色信息不能为空！");
        }
        String roleName = role.getRoleName();
        if (roleName == null) {
            throw new AppServiceException("修改角色失败，角色名称不能为空！");
        }
        int count = roleDao.editRole(role);
        if (count == -1) {
            throw new AppServiceException("修改角色信息失败，服务异常！");
        }
        return count;
    }

    @Override
    public int remove(Integer id) {
        if (id == null || id <= 0) {
            throw new AppServiceException("删除角色信息失败，角色ID必须大于0！");
        }
        int count = roleDao.removeRole(id);
        if (count == -1) {
            throw new AppServiceException("删除角色失败，服务异常！");
        }
        return count;
    }
}
