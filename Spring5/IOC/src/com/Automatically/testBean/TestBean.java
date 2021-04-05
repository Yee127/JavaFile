package com.Automatically.testBean;

import com.Automatically.bean.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {
    @Test
    public void test(){
        ApplicationContext context =  new ClassPathXmlApplicationContext("beanAuto.xml");
        Emp emp = context.getBean("emp", Emp.class);
        emp.test();
    }
}
