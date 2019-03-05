package net.le.minzhile.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @Author hanle
 * @Date 2019/1/20 21:17
 * @E-mail hanl1946@163.com
 */

public class TreeUtils {


    /**
     * 将list 解析为树状json
     * @param menuArray
     * @return
     */
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
