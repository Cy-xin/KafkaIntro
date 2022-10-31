package com.kafkaintro.controller;

import com.kafkaintro.aop.Notice;
import com.kafkaintro.enums.EventSceneEnums;
import com.kafkaintro.kafka.KafkaSender;
import com.kafkaintro.reqBean.MsgReq;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/kafka")
    @Notice(handler = EventSceneEnums.SendMsgEvent, msg = "#req.getMessage()")
    public String sendToTopic(@RequestBody MsgReq req) {
        return "Message sent";
    }
}
