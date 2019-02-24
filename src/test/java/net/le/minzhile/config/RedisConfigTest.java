package net.le.minzhile.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author hanle
 * @Date 2018/12/3 17:32
 * @E-mail hanl1946@163.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisConfigTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        this.redisTemplate = redisTemplate;
    }

    @Test
    public void testSetString() {
        stringRedisTemplate.opsForValue().set("aaa" , "111");
        Assert.assertEquals("111" , stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testSetObject() {
        long count = redisTemplate.opsForList().rightPush("login:user_id" , "50");
        Assert.assertTrue(count > 0);
    }

    @Test
    public void testStringRedis() {
        // 自增
        String id = stringRedisTemplate.opsForValue().get("global:user_info:user_id");
        long user_id = stringRedisTemplate.opsForValue().increment("global:user_info:user_id");
        Assert.assertTrue(Long.parseLong(id) + 1 == user_id);
        // 自减
        long last_id = stringRedisTemplate.opsForValue().decrement("global:user_info:user_id");
        Assert.assertTrue(Long.parseLong(id) == last_id);
    }

}
