package com.smart.springHook.Aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtils  implements ApplicationContextAware {

    private  ApplicationContext applicationContext;
    //是在applyBeanPostProcessorsBeforeInitialization中后置处理器ApplicationContextAwareProcessor
    // 调用SpringContextUtils.setApplicationContext的回调函数实现的。
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //获得当前上下环境
        this.applicationContext=applicationContext;
    }
}
