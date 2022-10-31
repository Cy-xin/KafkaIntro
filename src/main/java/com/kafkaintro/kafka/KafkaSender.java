package com.kafkaintro.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @Desc TODO
 * @Author XinKai
 * @Date 2022/10/31 10:30:28
 */
@Component
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, String payload) {
        kafkaTemplate.send(topic, payload);
        System.out.println("Message: "+payload+" sent to topic: "+topic);
    }
}
