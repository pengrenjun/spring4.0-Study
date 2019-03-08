package com.smart.EventAndListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*≤‚ ‘” º˛∑¢ÀÕº‡Ã˝*/
public class TestEventAndListener {

    public static void main(String[] args) {

        ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
        EventSender eventSender=ctx.getBean("eventSender",EventSender.class);
        MailSentEvent mail=new MailSentEvent(ctx,"…Ú—Ù –","xiaoli");
        eventSender.sendMail(mail);
    }
}
