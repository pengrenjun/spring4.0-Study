package com.smart.SpringAop2.schemaBased;

import org.aspectj.lang.JoinPoint;

/**基于spring2.0 的schema-base xml配置的切面处理代码*/
public class MethodAfterAspect {

    public void methodAfter(JoinPoint joinPoint){
        System.out.println("方法执行之后拦截处理");
        System.out.println("schema-base xml配置拦截处理代码："+joinPoint.toString());
    }
}
