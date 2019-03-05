                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            package net.le.minzhile.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.le.minzhile.exception.AppServiceException;
import net.le.minzhile.system.entity.Manager;
import net.le.minzhile.system.service.ManagerService;
import net.le.minzhile.web.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author hanle
 * @Date 2019/1/9 22:01
 * @E-mail hanl1946@163.com
 */

@Api(value = "管理员信息类")
@RestController
@RequestMapping("managers")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    /**
     * 分页获取管理员信息
     * @param currentPage 当前页
     * @return
     */
    @ApiOperation(value = "分页获取管理员信息信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "managerNum", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "managerName", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "managerMobile", dataType = "String", paramType = "query")
    })
    @GetMapping
    public JsonResult findAll(@RequestParam("currentPage") Integer currentPage,
                              @RequestParam("managerNum") String managerNum,
                              @RequestParam("managerName") String managerName,
                              @RequestParam("managerMobile") String managerMobile) {
        if (currentPage == null || currentPage <= 0) {
            throw new AppServiceException("获取管理员信息失败，当前页必须大于0！");
        }
        Map<String, Object> map = managerService.findAllManager(currentPage, managerNum, managerName, managerMobile);
        return new JsonResult(map);
    }

    /**
     * 添加管理员信息
     * @param manager
     * @return
     */
    @ApiOperation(value = "添加管理员信息")
    @ApiImplicitParam(name = "manager", required = true)
    @PostMapping
    public JsonResult addManager(@RequestBody Manager manager) {
        if(manager == null) {
            throw new AppServiceException("添加管理员信息失败，管理员信息不能为空！");
        }
        managerService.saveManager(manager);
        return new JsonResult();
    }

    /**
     * 修改管理员信息
     * @param manager
     * @return
     */
    @ApiOperation(value = "修改管理员信息")
    @ApiImplicitParam(name = "manager", required = true)
    @PutMapping
    public JsonResult editManager(@RequestBody Manager manager) {
        if(manager == null) {
            throw new AppServiceException("修改管理员信息失败，管理员信息不能为空！");
        }
        managerService.editManager(manager);
        return new JsonResult();
    }

    /**
     * 通过id删除管理员信息
     */
    @ApiOperation(value = "通过id删除管理员信息")
    @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "query")
    @DeleteMapping
    public JsonResult deleteManager(Integer id) {
        if (id == null || id <= 0) {
            throw new AppServiceException("删除管理员信息失败，管理员ID必须大于0！");
        }
        managerService.removeManager(id);
        return new JsonResult();
    }

    @ApiOperation(value = "通过id批量删除管理员信息！")
    @ApiImplicitParam(name = "ids", required = true, dataType = "string", paramType = "query")
    @DeleteMapping("/batch")
    public JsonResult batchDeleteManager(String ids) {
        if (ids == null) {
            throw new AppServiceException("删除管理员信息失败，管理员信息不能为空！");
        }
        managerService.batchRemoveManager(ids);
        return new JsonResult();
    }



}
