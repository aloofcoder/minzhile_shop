package net.le.minzhile.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import net.le.minzhile.system.dao.MenuDao;
import net.le.minzhile.system.service.MenuService;
import net.le.minzhile.util.TreeUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author hanle
 * @Date 2019/1/20 21:16
 * @E-mail hanl1946@163.com
 */
@Service
public class MenuServiceImpl implements MenuService {


    @Resource
    private MenuDao menuDao;


    /**
     * 分页获取菜单信息
     * @return
     */
    @Override
    public JSONArray findAllMenu() {
        List<Map<String, Object>> menuList = menuDao.findAllMenu();
        JSONArray menuArray = JSONArray.parseArray(JSON.toJSONString(menuList));
        JSONArray menuTree = TreeUtils.parseTree(menuArray);
        return menuTree;
    }
}
