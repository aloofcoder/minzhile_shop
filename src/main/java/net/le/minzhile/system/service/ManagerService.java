package net.le.minzhile.system.service;

import net.le.minzhile.system.entity.Manager;

import java.util.Map;

/**
 * @Author hanle
 * @Date 2019/1/9 22:09
 * @E-mail hanl1946@163.com
 */
public interface ManagerService {


    /**
     * 分页获取管理员信息
     * @param currentPage
     * @param managerNum
     * @param managerName
     * @param managerMobile
     * @return
     */
    Map<String, Object> findAllManager(
            Integer currentPage,
            String managerNum,
            String managerName,
            String managerMobile);

    /**
     * 保存管理员信息
     */
    int saveManager(Manager manager);

    /**
     * 修改管理员信息
     * @param manager
     * @return
     */
    int editManager(Manager manager);


    /**
     * 删除管理员信息
     * @param id
     */
    int removeManager(Integer id);

    /**
     * 批量删除管理员信息
     * @param ids
     */
    void batchRemoveManager(String ids);

}
