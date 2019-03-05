package net.le.minzhile.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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
//        List<Map<String, Object>> menuList = menuDao.findAllMenu();
//        JSONArray array= JSONArray.parseArray(JSON.toJSONString(menuList));
//        System.out.println("menuList >>> " + array);
//        JSONArray menuArray = TreeUtilsTest.parseTree(array);
//        System.out.println("menuArray >>> " + menuArray);
    }

    public static JSONArray parseTree(JSONArray menuArray) {

        int maxParentId = 0;
        // 获取最后一项父级菜单id
        for (int i = 0; i < menuArray.size(); i ++) {
            JSONObject menuJson = menuArray.getJSONObject(i);
            int parentId = menuJson.getInteger("parentId");
            if (parentId > maxParentId) {
                maxParentId = parentId;
            }
        }
        // 获取最后一项父级菜单
        JSONArray otherArray = new JSONArray();
        JSONArray parentArray = new JSONArray();
        for (int i = 0; i < menuArray.size(); i ++) {
            JSONObject menuJson = menuArray.getJSONObject(i);
            int id = menuJson.getInteger("id");
            if (maxParentId != id) {
                otherArray.add(menuJson);
            } else {
                parentArray.add(menuJson);
            }
        }
        if (parentArray.size() == 0) {
            return new JSONArray();
        }
        if (parentArray.size() > 1) {
            throw new RuntimeException("解析失败,祖节点只能有一个！");
        }
        JSONObject parentObject = parentArray.getJSONObject(0);
        JSONArray children = new JSONArray();
        JSONArray subArray = new JSONArray();
        for (int i = 0; i < otherArray.size(); i ++) {
            JSONObject menuJson = otherArray.getJSONObject(i);
            int parentId = menuJson.getInteger("parentId");
            if (parentId != maxParentId) {
                subArray.add(menuJson);
            } else {
                children.add(menuJson);
            }
        }
        if (menuArray.size() > 0) {
            parentObject.put("children", children);
            subArray.add(parentObject);
        }
        if (subArray.size() > 1) {
            menuArray = parseTree(subArray);
        } else {
            menuArray = subArray;
        }
        return menuArray;
    }


}
