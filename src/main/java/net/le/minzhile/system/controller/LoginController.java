package net.le.minzhile.system.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import net.le.minzhile.system.entity.Manager;
import net.le.minzhile.system.service.LoginService;
import net.le.minzhile.util.JwtTokenUtils;
import net.le.minzhile.web.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Author hanle
 * @Date 2019/1/11 1:53
 * @E-mail hanl1946@163.com
 */

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Value("${minzhile.login-secret}")
    private String loginSecret;

    @Autowired
    private LoginService loginService;

    /**
     * 管理员登录
     * @param manager
     * @param response
     * @return
     */
    @PostMapping
    public JsonResult login(@RequestBody Manager manager, HttpServletResponse response) {
        String managerNum = manager.getManagerNum();
        String managerPwd = manager.getManagerPwd();
        System.out.println(managerNum + "/" + managerPwd);
        Map<String, Object> map = loginService.login(managerNum, managerPwd);
        Manager loginManager = (Manager) map.get("manager");
        String token = (String)map.get("token");
        log.info("登录成功， 登录人：" + loginManager.getManagerName());
        response.setHeader("authorization", token);
        return new JsonResult();
    }


    /**
     * 验证管理员登录状态
     */
    @GetMapping("/check")
    public JsonResult checkLogin(HttpServletRequest request) {
        String authorization = request.getHeader("authorization");
        JwtTokenUtils jwtTokenUtils = new JwtTokenUtils(loginSecret);
        Claims claims = jwtTokenUtils.parseToken(authorization);
        // 取出token中的管理员账号
        String managerNum = claims.get("userNum").toString();
        Manager manager = loginService.checkLogin(managerNum);
        return new JsonResult(manager);
    }

}
