package net.le.minzhile.artive;

import net.le.minzhile.util.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author hanle
 * @Date 2018/12/6 22:10
 * @E-mail hanl1946@163.com
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArtiveTest {


    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        this.redisTemplate = redisTemplate;
    }

    public static final int ONE_WEEK_IN_SECONDS = 7 * 86400;

    public static final int VOTE_SCORE = 432;

    /**
     * 投票
     */
    @Test
    public void articleVote(String user, String article) {

    }
}
