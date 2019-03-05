package net.le.minzhile.cache.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Author hanle
 * @Date 2019/3/5 15:39
 * @E-mail hanl1946@163.com
 */
@Component
public class InitCache implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("================= 开始缓存数据 =================");
    }
}
