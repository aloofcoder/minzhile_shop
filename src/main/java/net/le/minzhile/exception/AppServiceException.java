package net.le.minzhile.exception;

/**
 * @Author hanle
 * @Date 2019/1/12 13:14
 * @E-mail hanl1946@163.com
 */
public class AppServiceException extends RuntimeException {

    public AppServiceException() {
        super();
    }
    public AppServiceException(String message, Throwable cause, boolean enableSuppression,
                            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    public AppServiceException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public AppServiceException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public AppServiceException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }
}
