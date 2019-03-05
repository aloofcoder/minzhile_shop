package net.le.minzhile.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.le.minzhile.exception.AppServiceException;
import net.le.minzhile.system.service.RoleService;
import net.le.minzhile.web.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author hanle
 * @Date 2019/2/26 21:46
 * @E-mail hanl1946@163.com
 */
@Api(value = "角色信息类")
@RequestMapping("/roles")
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation("分页获取角色信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "roleName", dataType = "String", paramType = "query")
    })
    @GetMapping
    public JsonResult findAll(@RequestParam("currentPage") Integer currentPage,
                              @RequestParam("roleName") String roleName) {
        if (currentPage == null || currentPage <= 0) {
            throw new AppServiceException("获取角色信息失败, 当前页必须大于0！");
        }
        Map<String, Object> map = roleService.findAllRole(currentPage, roleName);
        return new JsonResult(map);
    }
}
