package com.smart.SpringAop2.AspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**使用注解@Aspect配置 切面代码（类似于advice）*/

@Aspect
public class MethodBeforeAspect {

    /**定义方法执行之前的织入的代码*/
    @Before("com.smart.SpringAop2.AspectJ.SystemArchitecturePointCut.businessService()")
    public void methodBeforeExecute(JoinPoint joinPoint){
        System.out.println(
                "@Aspect配置的方法执行前置增强 ："+joinPoint.toLongString()
        );
    }
}

