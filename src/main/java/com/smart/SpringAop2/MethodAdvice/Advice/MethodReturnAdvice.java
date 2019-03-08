package com.smart.SpringAop2.MethodAdvice.Advice;

import com.google.gson.JsonObject;
import com.smart.SpringAop2.MethodAdvice.service.LogService;
import com.smart.domain.LoginLog;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

/**方法执行后拦截增强 记录日志*/
public class MethodReturnAdvice implements AfterReturningAdvice {

    private final AtomicInteger atomicInteger=new AtomicInteger(0);


    @Autowired private LogService logService;

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {

        String logInfo="执行方法"+method.getName()+"OK！"+" 入参："+args.toString()+" 返回结果："+returnValue.toString();

        System.out.println(logInfo);

        LoginLog log=new LoginLog();

        log.setLogInfo(logInfo);

        log.setLoginLogId(atomicInteger.incrementAndGet());

        logService.writelogInfo(log);

    }
}
