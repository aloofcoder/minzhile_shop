package net.le.minzhile.system.service;

import net.le.minzhile.system.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author hanle
 * @Date 2019/2/26 21:35
 * @E-mail hanl1946@163.com
 */
public interface RoleService {

    /**
     * 分页查询角色信息
     * @param currentPage
     * @param roleName
     * @return
     */
    Map<String, Object> findAllRole(Integer currentPage,
                                    String roleName);

    /**
     * 保存角色信息
     * @param role
     * @return
     */
    int saveRole(Role role);

    /**
     * 修改角色信息
     * @param role
     * @return
     */
    int editRole(Role role);

    /**
     * 删除角色信息
     * @param id
     * @return
     */
    int remove(Integer id);
}
