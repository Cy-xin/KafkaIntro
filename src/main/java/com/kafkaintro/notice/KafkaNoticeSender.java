package com.kafkaintro.notice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * 实现消息发送
 *
 * @Author XinKai
 * @Date 2022/10/31 11:22:33
 */
@Slf4j
@Component
public class KafkaNoticeSender implements NoticeSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void doSend(String topic, String jsonStr) {
        try {
            log.info("Message: " + jsonStr + "; sent to topic: " + topic);
            kafkaTemplate.send(topic, jsonStr);
        } catch (Exception e) {
            log.error("kafka error", e);
        }
    }
}
