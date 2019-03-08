package com.smart.SpringAop2.MethodAdvice;

import com.smart.SpringAop2.MethodAdvice.service.LogService;
import com.smart.SpringAop2.MethodAdvice.service.UserService;
import com.smart.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) throws Exception {


        //testA();//切面精确到了类，类里面的所有方法都进行拦截增强
        //testB();//切面精确到类中方法
        testC();//测试自动配置动态代理实例

    }

    private static void testC() {
        //启动Ioc容器
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:springAop2-AdviceB.xml");

        //获取代理的实例 实现了原代码的增强
        UserService userServiceProxy= applicationContext.getBean(UserService.class);


        User user=new User();
        user.setUserId(2);
        user.setUserName("小明");
        user.setPassword("123456");

        userServiceProxy.addUser(user);

        System.out.println("==========================================");
        try {
            userServiceProxy.queryUser(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testB() {
        //启动Ioc容器
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:springAop2-AdviceA.xml");

        //获取代理的实例 实现了原代码的增强
        UserService userServiceProxy=(UserService) applicationContext.getBean("userServiceProxyB");


        User user=new User();
        user.setUserId(2);
        user.setUserName("小明");
        user.setPassword("123456");

        userServiceProxy.addUser(user);

        System.out.println("==========================================");
        try {
            userServiceProxy.queryUser(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testA() {

        //启动Ioc容器
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:springAop2-AdviceA.xml");

        //获取代理的实例 实现了原代码的增强
        UserService userServiceProxy=(UserService) applicationContext.getBean("userServiceProxy");

        User user=new User();
        user.setUserId(1);
        user.setUserName("小李");
        user.setPassword("123456");

        userServiceProxy.addUser(user);

        System.out.println("==========================================");
        try {
            userServiceProxy.queryUser(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
