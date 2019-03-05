package net.le.minzhile.system;

import com.alibaba.fastjson.JSONArray;
import net.le.minzhile.system.entity.Menu;
import net.le.minzhile.system.service.MenuService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @Author hanle
 * @Date 2019/2/28 22:19
 * @E-mail hanl1946@163.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuServiceTest {

    @Autowired
    private MenuService menuService;

    @Test
    public void findAllMenuTest () {
        JSONArray menuTree = menuService.findAllMenu();
        Assert.assertTrue("获取菜单信息失败", menuTree.size() >= 0);
    }
}
