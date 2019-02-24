package net.le.minzhile.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author hanle
 * @Date 2019/1/11 1:04
 * @E-mail hanl1946@163.com
 */
public class PwdUtils {

    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if(n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
     * 创建加盐密码
     * @param managerPwd
     * @param salt
     * @return
     */
    public static String createSaltPwd(String managerPwd, String salt) {
        if (managerPwd == null) {
            throw new RuntimeException("密码不能为空！");
        }
        if(salt == null) {
            throw new RuntimeException("盐值不能为空！");
        }
        // 密码加密处理
        MessageDigest md = null;
        String pwd = "";
        try {
            md = MessageDigest.getInstance("MD5");
            String pwdAndSalt = managerPwd + "[" + salt + "]";
            pwd = byteArrayToHexString(md.digest(pwdAndSalt.getBytes("UTF-8")));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return pwd;
    }
}
