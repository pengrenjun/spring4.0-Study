package com.smart.EventAndListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/*�ʼ������¼�(�¼�����) ��Ҫ�̳�ApplicationContextEvent*/
public class MailSentEvent extends ApplicationContextEvent {

    //���յ�ַ
    private String addtress;
    //������
    private String receiver;


    /**
     * Create a new ContextStartedEvent.
     *  �¼�����Ĺ����� �����¼�Դsource
     * @param source the {@code ApplicationContext} that the event is raised for
     *               (must not be {@code null})
     */
    public MailSentEvent(ApplicationContext source,String addtress,String receiver) {
        super(source);
        this.addtress=addtress;
        this.receiver=receiver;
    }

    public String getAddtress() {
        return addtress;
    }

    public void setAddtress(String addtress) {
        this.addtress = addtress;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
