package net.le.minzhile.system.dao;

import net.le.minzhile.system.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author hanle
 * @Date 2019/2/24 18:48
 * @E-mail hanl1946@163.com
 */
public interface RoleDao {

    /**
     * 分页查询角色信息
     * @param startIndex
     * @param pageSize
     * @param roleName
     * @return
     */
    List<Role> findAllRole(@Param("startIndex") Integer startIndex,
                           @Param("pageSize") Integer pageSize,
                           @Param("roleName") String roleName);

    /**
     * 获取角色信息总条数
     * @param roleName
     * @return
     */
    int getRowCount(@Param("roleName") String roleName);

    /**
     *
     * @param roleName
     * @return
     */
    List<Role> findRoleByRoleName(String roleName);

    /**
     *
     * @param roleId
     * @return
     */
    List<Role> findRoleByRoleId(Integer roleId);

    /**
     * 添加角色信息
     * @param role
     * @return
     */
    int saveRole(Role role);

    /**
     * 修改角色信息
     * @return
     */
    int editRole(Role role);

    /**
     * 删除管理员信息
     */
    int removeRole(Integer id);
}
