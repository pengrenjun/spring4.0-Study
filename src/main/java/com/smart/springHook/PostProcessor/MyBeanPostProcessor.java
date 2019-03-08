package com.smart.springHook.PostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * ���ô���������ʼ��ǰ����д�����
 * �����ô��������뵽������
 * @author lfy
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("postProcessBeforeInitialization..."+beanName+"=>"+bean);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("postProcessAfterInitialization..."+beanName+"=>"+bean);
		//�޸�����
      /*  Car car = (Car)bean;
        if(car.getMaxSpeed() >= 200){
            System.out.println("����MyBeanPostProcessor.postProcessAfterInitialization()����maxSpeed����Ϊ200��");
            car.setMaxSpeed(200);
        }*/
		return bean;
	}

}
