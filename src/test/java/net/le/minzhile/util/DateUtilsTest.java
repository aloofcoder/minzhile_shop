package net.le.minzhile.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author hanle
 * @Date 2018/12/6 22:18
 * @E-mail hanl1946@163.com
 */
public class DateUtilsTest {

    @Test
    public void getTimeStampTest() {
        long timeStamp = DateUtils.getTimeStamp();
        Assert.assertNotNull(timeStamp);
    }
}
