package net.le.minzhile.system.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import net.le.minzhile.exception.AppServiceException;
import net.le.minzhile.system.service.MenuService;
import net.le.minzhile.web.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author hanle
 * @Date 2019/2/28 22:16
 * @E-mail hanl1946@163.com
 */
@Api("菜单信息接口类")
@RequestMapping("/menus")
@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;


    @ApiOperation("获取菜单信息")
    @GetMapping
    public JsonResult findAllMenu() {
        JSONArray menuTree = menuService.findAllMenu();
        return new JsonResult(menuTree);
    }

}
