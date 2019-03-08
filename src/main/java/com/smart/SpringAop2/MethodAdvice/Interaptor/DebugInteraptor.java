package com.smart.SpringAop2.MethodAdvice.Interaptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

//方法执行调试拦截
public class DebugInteraptor implements MethodInterceptor {

    //method to modify the original behavior
    @Override
    public Object invoke(MethodInvocation i) throws Throwable {
        System.out.println("调试拦截method "+i.getMethod()+" is called on "+ i.getThis()+" with args "+i.getArguments().toString());
        Object ret=i.proceed();
        System.out.println("method-> "+i.getMethod()+"  returns: "+ret.toString());
        return ret;
    }
}
