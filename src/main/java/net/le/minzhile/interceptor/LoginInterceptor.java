package net.le.minzhile.interceptor;

import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import net.le.minzhile.exception.AppLoginException;
import net.le.minzhile.exception.AppServiceException;
import net.le.minzhile.system.entity.UserClaims;
import net.le.minzhile.util.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @Author hanle
 * @Date 2019/1/12 17:14
 * @E-mail hanl1946@163.com
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Value("${minzhile.login-secret}")
    private String loginSecret;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        log.info("请求的url地址为：" + url);
        String loginUrl = request.getContextPath() + "/login";
        log.info(loginUrl.equals(url) + ": login地址");
        if(!loginUrl.equals(url)) {
            String authorization = request.getHeader("authorization");
            if (authorization == null) {
                throw new AppLoginException("您还未登录，请您先进行登录！");
            }
            System.out.println("authorization >>> " + authorization);
            JwtTokenUtils jwtTokenUtils = new JwtTokenUtils(loginSecret);
            try {
                Claims claims = jwtTokenUtils.parseToken(authorization);
                System.out.println("claims >>> " + claims);
                Date date = claims.getExpiration();
                System.out.println("date >>> " + date);
                System.out.println("date 1 >> " + date.getTime());
                System.out.println("currentTiem >>> " +  System.currentTimeMillis());
                long times = date.getTime() - System.currentTimeMillis();
                System.out.println(times);
                // 如果token验证通过 但有效时间小于10分钟进行刷新
                if (times <= 10 * 60 * 1000) {
                    String token = jwtTokenUtils.refurbishToken(claims);
                    response.setHeader("authorization", token);
                }
            } catch (Exception e) {
                throw new AppLoginException("您的登录失效请重新登录");
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
