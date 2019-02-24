package net.le.minzhile.file.entity;

import java.util.Date;

/**
 * @Author hanle
 * @Date 2019/1/31 17:00
 * @E-mail hanl1946@163.com
 */
public class File {

    private int id;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件保存路径
     */
    private String fileUrl;

    /**
     * 文件内容
     */
    private String fileContent;

    /**
     * 文件状态
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
