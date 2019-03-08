package com.smart.springHook.PostProcessor;

import java.util.Arrays;
import java.util.Iterator;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanFactoryPostProcessor...postProcessBeanFactory...");
		int count = beanFactory.getBeanDefinitionCount();
		String[] names = beanFactory.getBeanDefinitionNames();
		System.out.println("��ǰBeanFactory����"+count+" ��Bean");

        Iterator it = beanFactory.getBeanNamesIterator();

        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        // ��ȡ�����е�bean�����б�
        for(int i=0; i<beanDefinitionNames.length; i++){
            String name = beanDefinitionNames[i];

            BeanDefinition bd = beanFactory.getBeanDefinition(name);
            System.out.println(name + " bean properties: " + bd.getPropertyValues().toString());
            // ������ֻ�Ǹ�demo����ӡ���е�bean���������
        }
	}

}
