package net.le.minzhile.system.service.impl;

import net.le.minzhile.system.dao.MenuDao;
import net.le.minzhile.system.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author hanle
 * @Date 2019/1/20 21:16
 * @E-mail hanl1946@163.com
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuDao menuDao;


    @Override
    public List<Object> findAllMenu() {
        List<Map<String, Object>> menuList = menuDao.findAllMenu();
        return null;
    }
}
