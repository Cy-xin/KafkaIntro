package com.kafkaintro.aop;

import com.alibaba.fastjson.JSON;
import com.kafkaintro.enums.EventSceneEnums;
import com.kafkaintro.notice.KafkaNoticeService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Method;

/**
 * @Desc TODO
 * @Author XinKai
 * @Date 2022/10/31 14:24:57
 */

@Aspect
@Component
@Slf4j
public class NoticeAspect {

    LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();

    @Pointcut("@annotation(com.kafkaintro.aop.Notice)")
    public void notice(){}


    @AfterReturning("notice()")
    public void doAfterReturning(JoinPoint joinPoint){
        //获取切入方法的数据
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入方法
        Method method = signature.getMethod();
        //获得注解
        Notice noticeEvent = method.getAnnotation(Notice.class);
        if (noticeEvent == null) {
            return;
        }
        EvaluationContext args = getArgs(joinPoint, method);
        String msg = getSpelValue(args,noticeEvent.msg());
        EventSceneEnums[] handlers = noticeEvent.handler();
        for (EventSceneEnums eventSceneEnum : handlers) {
            KafkaNoticeService.send(eventSceneEnum, msg);
        }
    }

    private EvaluationContext getArgs(JoinPoint joinPoint,Method method){
        Object[] args = joinPoint.getArgs();
        String[] params = discoverer.getParameterNames(method);
        EvaluationContext context = new StandardEvaluationContext();
        for (int len = 0; len < params.length; len++) {
            context.setVariable(params[len], args[len]);
        }
        return context;
    }

    private String getSpelValue(EvaluationContext context, String spel) {
        String value = "";
        if (spel == null || "".equals(spel)) {
            return value;
        }
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(spel);
        Object obj = expression.getValue(context);
        if (obj instanceof String) {
            value = obj.toString();
        } else {
            value = JSON.toJSONString(obj);
        }
        return value;
    }
}
