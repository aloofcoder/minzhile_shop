package net.le.minzhile.exception;

/**
 * @Author hanle
 * @Date 2019/2/22 22:26
 * @E-mail hanl1946@163.com
 */
public class AppLoginException extends RuntimeException {
    public AppLoginException() {
        super();
    }

    public AppLoginException(String message) {
        super(message);
    }

    public AppLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppLoginException(Throwable cause) {
        super(cause);
    }

    protected AppLoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
