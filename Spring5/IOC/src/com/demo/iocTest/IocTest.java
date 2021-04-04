package com.demo.iocTest;

import com.demo.bean.Employee;
import com.demo.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocTest {
    @Test
    public void test1(){
//        加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

//        获取配置创建对象
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    @Test
    public void test2(){
//        加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

//        获取配置创建对象
        Employee employee = context.getBean("Employee", Employee.class);
        employee.info();
        System.out.println(employee.toString());
    }

    @Test
    public void test3(){
//        加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");

//        获取配置创建对象
        Employee employee = context.getBean("Employee", Employee.class);
        employee.info();
        System.out.println(employee.toString());
    }

    @Test
    public void test4(){
//        加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");

//        获取配置创建对象
        Employee employee = context.getBean("Employee", Employee.class);
        employee.info();
        System.out.println(employee.toString());
    }
}
