package net.le.minzhile.cache.service.impl;

import net.le.minzhile.cache.service.CacheService;
import net.le.minzhile.system.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author hanle
 * @Date 2019/3/5 15:38
 * @E-mail hanl1946@163.com
 */
@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    private ManagerService managerService;

    @Override
    public boolean loadCache() {
        return false;
    }

    @Override
    public boolean delCache() {
        return false;
    }
}
