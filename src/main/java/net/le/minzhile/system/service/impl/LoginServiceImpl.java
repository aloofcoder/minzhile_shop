package net.le.minzhile.system.service.impl;

import net.le.minzhile.exception.AppServiceException;
import net.le.minzhile.system.dao.ManagerDao;
import net.le.minzhile.system.entity.Manager;
import net.le.minzhile.system.entity.UserClaims;
import net.le.minzhile.system.service.LoginService;
import net.le.minzhile.util.JwtTokenUtils;
import net.le.minzhile.util.PwdUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author hanle
 * @Date 2019/1/10 22:17
 * @E-mail hanl1946@163.com
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Value("${minzhile.login-secret}")
    private String loginSecret;
    @Resource
    private ManagerDao managerDao;

    @Override
    public Map<String, Object> login(String managerNum, String managerPwd) {
        if(managerNum == null) {
            throw new AppServiceException("登录失败，管理员编号不能为空！");
        }
        if(managerPwd == null) {
            throw new AppServiceException("登录失败，管理员密码不能为空！");
        }
        List<Manager> managers = managerDao.findManagerInfoByManagerNum(managerNum);
        if(managers.size() == 0) {
            throw new AppServiceException("你输入的账号信息不存在！");
        }
        if(managers.size() > 1) {
            throw new AppServiceException("你输入的账号信息在系统中重复，请你联系系统管理员处理！");
        }
        Manager manager = managers.get(0);
        String salt = manager.getSalt();
        String nowSaltPwd = PwdUtils.createSaltPwd(managerPwd, salt);
        String saltPwd = manager.getManagerPwd();
        if(!saltPwd.equals(nowSaltPwd)) {
            throw new AppServiceException("你输入到密码不正确,请重新输入！");
        }
        // 登录成功设置用户登录token
        JwtTokenUtils jwtTokenUtils = new JwtTokenUtils(loginSecret);
        UserClaims claims = new UserClaims();
        claims.setUserNum(manager.getManagerNum());
        claims.setUserName(manager.getManagerName());
        claims.setPhone(manager.getManagerMobile());
        claims.setEmail(manager.getManagerEmail());
        claims.setExpiration(new Date(System.currentTimeMillis() + 2 * 60 * 60 * 1000));
        String token = jwtTokenUtils.createToken(claims);
        // 返回的信息
        Map<String, Object> map = new HashMap<>();
        map.put("manager", manager);
        map.put("token", token);
        return map;
    }

    /**
     * 验证管理员是否登录
     * @param managerNum
     * @return
     */
    @Override
    public Manager checkLogin(String managerNum) {
        if (managerNum == null) {
            throw new RuntimeException("获取管理员信息失败，管理员账号不能为空！");
        }
        List<Manager> managers = managerDao.findManagerInfoByManagerNum(managerNum);
        if (managers.size() <= 0) {
            throw new RuntimeException("获取管理员信息失败，该管理员账号不存在！");
        }
        if (managers.size() > 1) {
            throw new RuntimeException("获取管理员信息失败，该管理员账号重复，请联系管理员进行处理！");
        }
        return managers.get(0);
    }
}
