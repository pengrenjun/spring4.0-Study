package com.smart.EventAndListener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/*�¼������� ��Ҫ�̳�ApplicationListener*/
public class EventListener  implements ApplicationListener<ApplicationEvent> {


    @Override
    public void onApplicationEvent(ApplicationEvent event) {

       if(event.getClass().equals(MailSentEvent.class)){

               MailSentEvent mailSentEvent=(MailSentEvent)event;
               System.out.println("�������������ʼ�����"+"��ַ��"+mailSentEvent.getAddtress()+" �ռ���:"+mailSentEvent.getReceiver());
       }
    }


    public static class SpringAopTest {
    }
}
