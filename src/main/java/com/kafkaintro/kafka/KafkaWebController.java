package com.kafkaintro.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Desc TODO
 * @Author XinKai
 * @Date 2022/10/31 10:32:04
 */
@RestController
public class KafkaWebController {

    @Autowired
    KafkaSender kafkaSender;

    @PostMapping("/kafka/{topicName}")
    public String sendToTopic(@PathVariable String topicName, @RequestBody String message) {
        kafkaSender.send(topicName, message);
        return "Message sent";
    }

    @GetMapping("/get")
    public String test() {
        return "test";
    }
}
