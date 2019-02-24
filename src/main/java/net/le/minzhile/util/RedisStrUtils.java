package net.le.minzhile.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author hanle
 * @Date 2018/12/6 22:29
 * @E-mail hanl1946@163.com
 */
@Component
public class RedisStrUtils {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


}
