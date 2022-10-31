package com.kafkaintro.aop;

import com.kafkaintro.enums.EventSceneEnums;

import java.lang.annotation.*;

/**
 * 注解
 *
 * @author XinKai
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Notice {
    /**
     * 传入的事件类型（包含要发送的主题）
     *
     * @return
     */
    EventSceneEnums[] handler();

    String msg() default "";
}
