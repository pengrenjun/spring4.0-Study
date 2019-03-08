package com.smart.SpringAop2.MethodAdvice.Advice;

import com.smart.SpringAop2.MethodAdvice.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;

/**方法执行前拦截增强*/
public class MethodBeforeAdvice implements org.springframework.aop.MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {

        System.out.println("方法执行前拦截--》"+"执行方法："+method.getName()+" 入参："+args.toString());

    }
}
