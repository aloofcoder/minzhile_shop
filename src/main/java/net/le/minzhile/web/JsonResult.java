package net.le.minzhile.web;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author hanle
 * @Date 2019/1/12 12:15
 * @E-mail hanl1946@163.com
 */
@Setter
@Getter
@ToString
public class JsonResult implements Serializable {

    public static final int SUCCESS = 0;
    public static final int ERROR = 1;
    private static final long serialVersionUID = 7944549109489593620L;

    private int state;

    private String message;

    private Object data;

    public JsonResult() {
        this.state = SUCCESS;
        this.message = "SUCCESS";
    }

    public JsonResult(Object data) {
        this();
        this.data = data;
    }

    public JsonResult(Throwable t) {
        this.state = ERROR;
        this.message = t.getMessage();
    }
}
