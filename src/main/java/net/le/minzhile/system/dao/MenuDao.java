package net.le.minzhile.system.dao;

import java.util.List;
import java.util.Map;

/**
 * @Author hanle
 * @Date 2019/1/20 21:07
 * @E-mail hanl1946@163.com
 */
public interface MenuDao {

    List<Map<String, Object>> findAllMenu();

}
