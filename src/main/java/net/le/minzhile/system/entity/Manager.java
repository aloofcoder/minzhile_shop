package net.le.minzhile.system.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.le.minzhile.system.enums.ManagerValidEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author hanle
 * @Date 2019/1/9 22:01
 * @E-mail hanl1946@163.com
 */

@NoArgsConstructor
@Setter
@Getter
@ToString
public class Manager implements Serializable {

    private static final long serialVersionUID = -2403324629522427691L;

    private Integer id;
    /**
     * 管理员编号
     */
    private String managerNum;
    /**
     * 管理员密码
     */
    private String managerPwd;
    /**
     * 管理员姓名
     */
    private String managerName;

    /**
     * 角色字符串
     */
    private String roleStr;

    /**
     * 管理员电话
     */
    private String managerMobile;

    /**
     * 管理员邮箱
     */
    private String managerEmail;

    /**
     * 管理员头像
     */
    private String managerAvatar;

    /**
     * 密码盐值
     */
    private String salt;

    /**
     * 管理员状态
     */
    private Integer valid;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date editTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 修改人
     */
    private String editUser;

}
