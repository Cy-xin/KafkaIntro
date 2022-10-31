package com.kafkaintro.notice;

import com.kafkaintro.enums.EventSceneEnums;
import com.kafkaintro.utils.SpringBeanContextUtil;

import java.util.Map;

/**
 * 封装抽象服务类，用于实现其他实现继承此类
 *
 * @Author XinKai
 * @Date 2022/10/31 11:31:06
 */
public abstract class KafkaNoticeService extends KafkaNoticeSender {

    /**
     * 通知
     *
     * @param topic
     * @return
     */
    public abstract boolean notice(String topic, String msgInfo);

    /**
     * 发送
     *
     * @param eventSceneEnum 要发送消息注入的bean
     * @return
     */
    public static boolean send(EventSceneEnums eventSceneEnum, String msgInfo) {
        return ((KafkaNoticeService) SpringBeanContextUtil.getBean(eventSceneEnum.name())).notice(eventSceneEnum.getTopic(), msgInfo);
    }

}
