package net.le.minzhile.kafka;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author hanle
 * @Date 2018/12/27 23:40
 * @E-mail hanl1946@163.com
 */

@Slf4j
//@Component
public class KafkaConsumer {

    @KafkaListener(topics = "demo")
    public void processMessage(String content) {
        System.out.println("topic 为demo的消息：" + content);
        log.debug("topic 为demo的消息：" + content);
        log.info("topic 为demo的消息：" + content);
    }
}
