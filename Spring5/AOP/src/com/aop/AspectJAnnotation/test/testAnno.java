package com.aop.AspectJAnnotation.test;

import com.aop.AspectJAnnotation.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testAnno {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beanAspectJ.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }
}
