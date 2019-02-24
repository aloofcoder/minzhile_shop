package net.le.minzhile.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.*;
import net.le.minzhile.exception.AppServiceException;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

/**
 * @Author hanle
 * @Date 2019/1/9 13:28
 * @E-mail hanl1946@163.com
 */
public class JwtTokenUtils {

    private SecretKeySpec secret;

    /**
     *
     * @param secret token 秘钥
     */
    public JwtTokenUtils (String secret) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), SignatureAlgorithm.HS512.getJcaName());
        this.secret = secretKeySpec;
    }


    /**
     * 生成 Token
     */
    public String createToken(Claims claims) {
        String compactJws = Jwts.builder().setPayload(JSONObject.toJSONString(claims))
                .compressWith(CompressionCodecs.DEFLATE).signWith(SignatureAlgorithm.HS512, secret).compact();
        return compactJws;
    }


    public Claims parseToken(String token){
        Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
            throw new AppServiceException("登录超时，请您重行登录！");
        }
        return claims;
    }

    public String refurbishToken(Claims claims) {
        claims.setExpiration(new Date(System.currentTimeMillis() + 3600000));
        String compactJws = Jwts.builder().setPayload(JSONObject.toJSONString(claims))
                .compressWith(CompressionCodecs.DEFLATE).signWith(SignatureAlgorithm.HS512, secret).compact();
        return compactJws;
    }
}
