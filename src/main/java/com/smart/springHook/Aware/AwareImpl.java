package com.smart.springHook.Aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

@Component
public class AwareImpl implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware, BeanFactoryAware {
    private ApplicationContext applicationContext;

    private BeanFactory beanFactory;

    @Override
    public void setBeanName(String s) {
        System.out.println("当前bean的名字:"+s);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        System.out.println("传入的IOC容器: "+applicationContext);
        this.applicationContext = applicationContext;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        String result = stringValueResolver.resolveStringValue("你好${os.name}, 计算#{3*8}");
        System.out.println("解析的字符串为---"+result);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory=beanFactory;

    }
}
