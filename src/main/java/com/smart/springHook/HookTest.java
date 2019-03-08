package com.smart.springHook;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HookTest {

    public static void main(String[] args) {
        testA();
    }

    private static void testA() {

        //启动容器
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:smart-context.xml");


    }
}
