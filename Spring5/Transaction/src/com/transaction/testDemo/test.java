package com.transaction.testDemo;

import com.transaction.bean.Config;
import com.transaction.service.TranService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beanJdbc.xml");
        TranService tranService = context.getBean("tranService", TranService.class);
        tranService.accountMoney();
    }

    @Test
    public void test2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        TranService tranService = context.getBean("tranService", TranService.class);
        tranService.accountMoney();
    }
}
