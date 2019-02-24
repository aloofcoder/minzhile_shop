package net.le.minzhile.system;

import net.le.minzhile.system.service.LoginService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author hanle
 * @Date 2019/1/11 1:47
 * @E-mail hanl1946@163.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerLoginTest {

    @Resource
    private LoginService loginService;

    @Test
    public void testLogin () {
        Map<String, Object> map = loginService.login("admin", "admin");
        System.out.println("loginInfo" + map);
        Assert.assertTrue(map.get("token") != null);
    }
}
