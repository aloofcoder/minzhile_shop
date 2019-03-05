package net.le.minzhile.system;

import net.le.minzhile.system.entity.Role;
import net.le.minzhile.system.service.RoleService;
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
 * @Date 2019/2/27 22:12
 * @E-mail hanl1946@163.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTest {

    @Autowired
    private RoleService roleService;

    /**
     * 测试分页查询角色信息
     */
    @Test
    public void testFindAllRole () {
        Map<String , Object> map = roleService.findAllRole(1, "");
        List<Role> roleList = (List<Role>)map.get("list");
        Assert.assertTrue("测试查询角色信息失败！", roleList.size() >= 0);
    }

    /**
     * 测试添加角色信息
     */
    @Test
    public void testSaveRole () {
        Role role = new Role();
        role.setRoleName("普通用户");
        role.setCreateUser("管理员");
        role.setEditUser("管理员");
        int count = roleService.saveRole(role);
        Assert.assertTrue("测试添加角色失败！", count == 1);
    }

    /**
     * 测试修改角色信息
     */
    @Test
    public void testEditRole () {
        Map<String , Object> map = roleService.findAllRole(1, "");
        List<Role> roleList = (List<Role>)map.get("list");
        Role role = roleList.get(0);
        role.setRoleName("管理员");
        role.setEditUser("测试修改");
        int count = roleService.editRole(role);
        Assert.assertTrue("测试修改角色失败！", count == 1);
    }

    @Test
    public void testRemoveRole () {
        Map<String , Object> map = roleService.findAllRole(1, "");
        List<Role> roleList = (List<Role>)map.get("list");
        Role role = roleList.get(0);
        int count = roleService.remove(role.getId());
        Assert.assertTrue("测试删除角色失败！", count == 1);
    }
}
