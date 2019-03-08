package com.smart.SpringAop2.AspectJ;

import com.smart.SpringAop2.MethodAdvice.service.UserService;
import com.smart.SpringAop2.MethodAdvice.service.XhContractService;
import com.smart.domain.User;
import com.smart.domain.XhContractExecution;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {


    public static void main(String[] args) {

        testA();
    }

    private static void testA() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:springAop2-@Aspect.xml");


        //??????????? ??????????????
        UserService userServiceProxy= applicationContext.getBean(UserService.class);
        XhContractService xhContractServiceProxy=applicationContext.getBean(XhContractService.class);


        User user=new User();
        user.setUserId(2);
        user.setUserName("§³??");
        user.setPassword("123456");

        userServiceProxy.addUser(user);

        XhContractExecution xhContractExecution=new XhContractExecution("123456","??????");
        xhContractServiceProxy.addContract(xhContractExecution);



    }
}
