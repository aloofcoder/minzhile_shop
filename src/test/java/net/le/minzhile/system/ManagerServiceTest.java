package net.le.minzhile.system;

import lombok.extern.slf4j.Slf4j;
import net.le.minzhile.system.entity.Manager;
import net.le.minzhile.system.service.ManagerService;
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
 * @Date 2019/1/10 22:32
 * @E-mail hanl1946@163.com
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerServiceTest {

    @Autowired
    private ManagerService managerService;

    /**
     * 测试分页查询管理员信息
     */
    @Test
    public void testFindAllManager() {
        Map<String, Object> map = managerService.findAllManager(1);
        System.out.println(map);
        List<Manager> lists = (List<Manager>)map.get("list");
        Assert.assertTrue(lists.size() >= 0);
    }

    /**
     * 测试添加管理员
     */
    @Test
    public void testSaveManager () {
        Manager manager = new Manager();
        manager.setManagerNum("admin" + System.currentTimeMillis() / 1000);
        manager.setManagerPwd("admin");
        manager.setManagerName("韩乐");
        manager.setManagerMobile("18149197030");
        manager.setCreateUser("管理员");
        manager.setEditUser("管理员");
        int count = managerService.saveManager(manager);
        Assert.assertTrue(count == 1);
    }

    /**
     * 测试修改管理员
     */
    @Test
    public void testEditManager() {
        Map<String, Object> map = managerService.findAllManager(1);
        System.out.println(map);
        List<Manager> lists = (List<Manager>)map.get("list");
        if (lists.size() <= 0) {
            log.error("测试ManagerServiceTest -> testEditManager 方法修改管理员信息失败，数据库无管理员信息！");
        }
        Manager manager = lists.get(0);
        manager.setManagerName("超级管理员");
        int count = managerService.editManager(manager);
        Assert.assertTrue(count == 1);
    }


    /**
     * 测试删除管理员信息
     */
    @Test
    public void deleteManager() {
        Map<String, Object> map = managerService.findAllManager(1);
        System.out.println(map);
        List<Manager> lists = (List<Manager>)map.get("list");
        if (lists.size() <= 0) {
            log.error("测试ManagerServiceTest -> deleteManager 方法删除管理员信息失败，数据库无管理员信息！");
        }
        Manager manager = lists.get(0);
        int count = managerService.removeManager(manager.getId());
        Assert.assertTrue("删除管理员信息失败！",count == 1);
    }
}
