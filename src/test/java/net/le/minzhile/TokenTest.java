package net.le.minzhile;

import io.jsonwebtoken.Claims;
import net.le.minzhile.system.entity.UserClaims;
import net.le.minzhile.util.JwtTokenUtils;
import org.junit.Test;

import java.util.Date;

/**
 * @Author hanle
 * @Date 2019/1/9 13:45
 * @E-mail hanl1946@163.com
 */
public class TokenTest {
    public static void main(String[] args) {
        // md5("7981798723412342134"); > 签名

        // 密钥 12345678
        JwtTokenUtils jwtTokenProvider = new JwtTokenUtils("12345678");
        UserClaims claims = new UserClaims();
        claims.setPhone("15098102029");
        claims.setUserName("Tony");
        claims.setEmail("tony@qq.com");
        // token有效期
        claims.setExpiration(new Date(System.currentTimeMillis() + 60000));

        String token = jwtTokenProvider.createToken(claims);
        System.out.println("生成的token：" + token);
        // 生成Token
        Claims userClaims = jwtTokenProvider.parseToken(token);
        System.out.println("解析出来的Toekn内容：" + userClaims);
    }

    @Test
    public void createToken () {
        JwtTokenUtils jwtTokenUtils = new JwtTokenUtils("hanle!@#123");
        UserClaims userClaims = new UserClaims();
        userClaims.setUserName("han le");
        userClaims.setPhone("15891480513");
        userClaims.setExpiration(new Date(System.currentTimeMillis() + 60000));
        String token = jwtTokenUtils.createToken(userClaims);
        System.out.println("生成的Token ===> " + token);
    }

    @Test
    public void parseToken () {
        JwtTokenUtils jwtTokenUtils = new JwtTokenUtils("hanle!@#123");
        Claims userClaims = jwtTokenUtils.parseToken("eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNqqViotTi3yS8xNVbJSykjMU8hJVdJRKsjIzwMJGJpaWBqaWBiYGhoDRVMrCpSsDE1NzA1MjIxNTWoBAAAA__8.fec7clysDr2KHHm1-hf0PQh80FyEG6MCRc4MSo4RphQxXsfhI6moXTPuz_AN_pmdSKcwyE4JV8U58KooGdLwLQ");
        System.out.println("解析后的token ==> " + userClaims);
    }
}
