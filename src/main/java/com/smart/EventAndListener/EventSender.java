package com.smart.EventAndListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/*�¼������� ʵ��ApplicationContextAware�ӿ� ����ע������������ʵ�� */
public class EventSender implements ApplicationContextAware {

    //ע������������ʵ��
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    //�ʼ����ͷ�����
    public void sendMail(MailSentEvent mailSentEvent) {

        System.out.println("�ʼ���ʼ����");
        //�����ʼ������¼�
        applicationContext.publishEvent(mailSentEvent);
    }


}
