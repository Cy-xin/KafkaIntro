package com.kafkaintro.enums;

/**
 * 消息通知事件枚举
 *
 * @Author XinKai
 * @Date 2022/10/31 11:34:31
 */
public enum EventSceneEnums {

    SendMsgEvent("topic1", "发送消息事件");

    private String topic;
    private String name;

    EventSceneEnums(String topic, String name) {
        this.topic = topic;
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public String getName() {
        return name;
    }
}
