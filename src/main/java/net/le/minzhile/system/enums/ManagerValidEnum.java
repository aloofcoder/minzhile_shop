package net.le.minzhile.system.enums;

/**
 * @Author hanle
 * @Date 2019/1/12 12:06
 * @E-mail hanl1946@163.com
 */
public enum ManagerValidEnum {
    RED("红色", 1),
    GREEN("绿色", 2),
    BLANK("白色", 3),
    YELLO("黄色", 4);

    private String name;
    private int index;

    private ManagerValidEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
