package com.kafkaintro.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 获取springBean工具类，用于访问容器中定义的其他bean
 *
 * @Author XinKai
 * @Date 2022/10/31 11:39:34
 */
@Component
public class SpringBeanContextUtil implements ApplicationContextAware {

    /**
     * Spring应用上下文环境
     */
    private static ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }


    /**
     * 获取对象 这里重写了bean方法，起主要作用
     *
     * @param name bean名称
     * @return Object 一个以所给名字注册的bean的实例
     * @throws BeansException
     */
    public static Object getBean(String name) throws BeansException {
        return applicationContext.getBean(name);
    }
}
