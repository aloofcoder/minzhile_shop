package net.le.minzhile.system.dao;

import net.le.minzhile.system.entity.Manager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author hanle
 * @Date 2019/1/9 22:13
 * @E-mail hanl1946@163.com
 */

public interface ManagerDao {

    /**
     * 分页查询管理员
     * @return
     */
    List<Manager> findAllManager(
            @Param("startIndex") Integer startIndex,
            @Param("pageSize") Integer pageSize,
            @Param("managerNum") String managerNum,
            @Param("managerName") String managerName,
            @Param("managerMobile") String managerMobile);

    /**
     * 获取管理员总数
     * @return
     */
    int getRowCount(@Param("managerNum") String managerNum,
                    @Param("managerName") String managerName,
                    @Param("managerMobile") String managerMobile);

    /**
     * 添加管理员
     * @param manager 管理员实体
     * @return
     */
    int saveManager(Manager manager);

    /**
     * 根据用户编号查找管理员信息
     * @param managerNum
     * @return
     */
    List<Manager> findManagerInfoByManagerNum(String managerNum);

    /**
     * 修改管理员信息
     * @param manager
     * @return
     */
    int editManager(Manager manager);

    /**
     * 删除管理员信息
     * @param id
     * @return
     */
    int removeManager(Integer id);
}
