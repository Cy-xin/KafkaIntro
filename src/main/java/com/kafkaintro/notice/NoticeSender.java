package com.kafkaintro.notice;

/**
 * 发送消息
 *
 * @Author XinKai
 * @Date 2022/10/31 11:21:25
 */
public interface NoticeSender {

    /**
     * 发送消息
     *
     * @param topic   主题
     * @param jsonStr 发送数据
     */
    void doSend(String topic, String jsonStr);
}
