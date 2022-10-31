package com.kafkaintro.notice;

import com.kafkaintro.event.EventInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * @Desc TODO
 * @Author XinKai
 * @Date 2022/10/31 11:47:49
 */
@Slf4j
@Component
public abstract class KafkaEventNoticeSender extends KafkaNoticeService implements EventInfo {

    /**
     * 子类可覆盖
     *
     * @param msgInfo
     * @return
     */
    @Override
    public String createMsgInfo(String msgInfo) {
        return "消息发送......";
    }

    @Override
    public boolean notice(String topic, String msgInfo) {
        String resultInfo = createMsgInfo(msgInfo);
        super.doSend(topic, resultInfo);
        return true;
    }

}
