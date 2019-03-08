package com.smart.SpringAop2.AspectJ;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**spring建议的将切点规整到一个类中 配置时直接获取*/

@Aspect //标记这个Bean为AOP配置类
public class SystemArchitecturePointCut {

    // web 层
    @Pointcut("within(com.smart.web..*)")
    public void inWebLayer() {}

    // service 层
    @Pointcut("within(com.smart.service..*)")
    public void inServiceLayer() {}

    // dao 层
    @Pointcut("within(com.smart.dao..*)")
    public void inDataAccessLayer() {}

    // service 实现，注意这里指的是方法实现，其实通常也可以使用 bean(*ServiceImpl)
    @Pointcut("execution(* com.smart..service.*.*(..))")
    public void businessService() {}

    // dao 实现
    @Pointcut("execution(* com.smart.dao.*.*(..))")
    public void dataAccessOperation() {}
}
