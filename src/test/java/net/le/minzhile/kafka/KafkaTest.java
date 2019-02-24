package net.le.minzhile.kafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author hanle
 * @Date 2018/12/27 23:25
 * @E-mail hanl1946@163.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaTest {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Test
    public void testSendMsg() {
        kafkaProducer.sendMessage();
    }
}
