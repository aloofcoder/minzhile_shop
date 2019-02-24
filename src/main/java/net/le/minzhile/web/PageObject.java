package net.le.minzhile.web;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @Author hanle
 * @Date 2019/1/10 22:56
 * @E-mail hanl1946@163.com
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class PageObject implements Serializable {

    private static final long serialVersionUID = -659949948900949151L;

    private Integer currentPage;

    private Integer pageSize;

    private Integer totalRow;

    private Integer totalPage;

    public static int getTotalPage(int totalRow, int pageSize) {
        if (totalRow % pageSize != 0) {
            return totalRow / pageSize + 1;
        }
        return totalRow / pageSize;
    }
}
