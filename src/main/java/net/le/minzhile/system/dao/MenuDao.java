package net.le.minzhile.system.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author hanle
 * @Date 2019/1/20 21:07
 * @E-mail hanl1946@163.com
 */
public interface MenuDao {

    /**
     * 分页查询菜单信息
     * @return
     */
    List<Map<String, Object>> findAllMenu();

    /**
     * 获取所有菜单条数
     * @return
     */
    int getRowCount();
}
