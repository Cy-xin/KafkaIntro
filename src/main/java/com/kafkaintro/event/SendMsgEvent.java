package com.kafkaintro.event;

import com.kafkaintro.notice.KafkaEventNoticeSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Desc TODO
 * @Author XinKai
 * @Date 2022/10/31 11:46:54
 */
@Slf4j
@Component("SendMsgEvent")
public class SendMsgEvent extends KafkaEventNoticeSender {

    @Override
    public String createMsgInfo(String msgInfo) {
        return "Send Msg Event :" + msgInfo;
    }
}
