package net.le.minzhile.system.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author hanle
 * @Date 2019/2/20 19:29
 * @E-mail hanl1946@163.com
 */
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Role implements Serializable {

    private static final long serialVersionUID = -7467912882207681680L;

    private Integer id;

    private String roleName;

    private Integer valid;

    private String remark;

    private Date createTime;

    private Date editTime;

    private String createUser;

    private String editUser;
}
