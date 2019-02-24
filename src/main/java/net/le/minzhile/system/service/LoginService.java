package net.le.minzhile.system.service;


import net.le.minzhile.system.entity.Manager;

import java.util.Map;

/**
 * @Author hanle
 * @Date 2019/1/10 22:17
 * @E-mail hanl1946@163.com
 */
public interface LoginService {

    Map<String, Object> login(String userNum, String userPwd);

    Manager checkLogin(String managerNum);
}
