package net.le.minzhile.system.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author hanle
 * @Date 2019/1/20 21:03
 * @E-mail hanl1946@163.com
 */

@NoArgsConstructor
@Setter
@Getter
@ToString
public class Menu implements Serializable {

    private Integer id;

    private String menuName;

    private Integer menuType;

    private String menuUrl;

    private Integer parentId;

    private Integer valid;

    private String remark;

    private Date createTime;

    private Date editTime;

    private String createUser;

    private String editUser;
}
