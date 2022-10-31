package com.kafkaintro.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Desc TODO
 * @Author XinKai
 * @Date 2022/10/31 10:31:14
 */
@Component
public class KafkaReceiver {

    @KafkaListener(topics = "topic1")
    public void receiveTopic1(ConsumerRecord<?, ?> consumerRecord) {
        System.out.println("Receiver on topic1: "+consumerRecord.toString());
    }

    @KafkaListener(topics = "topic2")
    public void receiveTopic2(ConsumerRecord<?, ?> consumerRecord) {
        System.out.println("Receiver on topic2: "+consumerRecord.toString());
    }

}
