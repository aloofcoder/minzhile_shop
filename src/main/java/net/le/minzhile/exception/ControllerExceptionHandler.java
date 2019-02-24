package net.le.minzhile.exception;

import lombok.extern.slf4j.Slf4j;
import net.le.minzhile.web.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 拦截异常统一处理
 * @Author hanle
 * @Date 2019/1/12 13:16
 * @E-mail hanl1946@163.com
 */
@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    /**
     * 对自定义异常AppServiceException 处理
     * @param e
     * @return
     */
    @ExceptionHandler(AppServiceException.class)
    @ResponseBody
    public JsonResult handlerAppServiceException(AppServiceException e) {
        e.printStackTrace();
        log.debug("服务异常：" + e.getMessage());
        return new JsonResult(e);
    }

    /**
     * 对自定义异常AppLoginException 处理
     * @param e
     * @return
     */
    @ExceptionHandler(AppLoginException.class)
    @ResponseBody
    public JsonResult handlerAppLoginException(HttpServletResponse response, AppLoginException e) {
        response.setStatus(401);
        e.printStackTrace();
        log.debug("服务异常：" + e.getMessage());
        return new JsonResult(e);
    }

}
