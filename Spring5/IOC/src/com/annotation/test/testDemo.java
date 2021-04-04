package com.annotation.test;

import com.annotation.bean.SpringConfig;
import com.annotation.bean.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class testDemo {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beanAnnotation.xml");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.info();
    }


    @Test
    public void test1(){
        //加载配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.info();
    }
}
