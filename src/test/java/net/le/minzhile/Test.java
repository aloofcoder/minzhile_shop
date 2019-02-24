package net.le.minzhile;

import net.le.minzhile.util.PwdUtils;
import java.util.Base64;
import java.util.UUID;

/**
 * @Author hanle
 * @Date 2019/1/10 14:24
 * @E-mail hanl1946@163.com
 */
public class Test {


    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString();
        String salt = Base64.getEncoder().encodeToString(uuid.getBytes());
        System.out.println(salt);
        System.out.println(PwdUtils.createSaltPwd("hanle232", "YmY0NzBiYWMtNGY4ZS00ZTI1LTg3NTAtZDk0M2QzZTIyMzY2"));
    }

}
