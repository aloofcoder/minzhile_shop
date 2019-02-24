package net.le.minzhile.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import net.le.minzhile.system.dao.MenuDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author hanle
 * @Date 2019/1/20 21:19
 * @E-mail hanl1946@163.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TreeUtilsTest {

    @Resource
    private MenuDao menuDao;


    @Test
    public void parseTreeNode() {
        List<Map<String, Object>> menuList = menuDao.findAllMenu();
        List<Map<String, Object>> parentList = new ArrayList<>();
        for (int i = 0; i < menuList.size(); i ++) {
            // 给每一项菜单添加children 属性
            menuList.get(i).put("children", new ArrayList<Map<String, Object>>());
        }
    }

    public void parseTree (List<Map<String, Object>> menuList) {
        for (int i = 0; i < menuList.size(); i ++) {
            String menuName = menuList.get(i).get("menuName").toString();
            System.out.println("menuName >> " + menuName);
            for (int j = 0; j < menuList.size(); j ++) {
                System.out.println("menu >> " + menuList.get(j).get("menuName") + j);
            }
        }
        System.out.println("menu >> " + menuList);
    }

}
