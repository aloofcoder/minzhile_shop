package net.le.minzhile.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author hanle
 * @Date 2018/12/6 22:16
 * @E-mail hanl1946@163.com
 */
public class DateUtils {

    /**
     * 获取当前时间戳
     */
    public static long getTimeStamp() {
        Calendar cal = Calendar.getInstance();
        return cal.getTimeInMillis() / 1000;
    }

    /**
     * 获取当前年月日
     * @return
     */
    public static String getNowDate() {
        return DateUtils.getNow("yyyy-MM-dd");
    }

    public static String getNowTime() {
        return DateUtils.getNow("yyyy-MM-dd HH:mm:ss");
    }


    /**
     * 通过解析格式获取当前时间
     * @param pattern
     * @return
     */
    public static String getNow(String pattern) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String nowDate = sdf.format(cal.getTime());
        return nowDate;
    }
}
