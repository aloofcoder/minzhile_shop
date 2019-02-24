package net.le.minzhile.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author hanle
 * @Date 2018/12/27 23:23
 * @E-mail hanl1946@163.com
 */
//@Component
public class KafkaProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMessage() {
        kafkaTemplate.send("demo" , "hi kafka");
    }
}
