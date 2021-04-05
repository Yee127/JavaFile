package com.Arr_List_Map.testDemo;

import com.Arr_List_Map.bean.Book;
import com.Arr_List_Map.bean.Course;
import com.Arr_List_Map.bean.Stu;
import com.Arr_List_Map.beanLife.Orders;
import com.Arr_List_Map.factoryBean.MyBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testDemoA {
    @Test
    public void testStu(){
        ApplicationContext context =  new ClassPathXmlApplicationContext("beanStu.xml");
        Stu stu = context.getBean("Stu", Stu.class);
        stu.info();
    }


    @Test
    public void testBook(){
        ApplicationContext context =  new ClassPathXmlApplicationContext("beanBook.xml");
        Book book = context.getBean("book", Book.class);
        book.info();
    }
    @Test
    public void testFactoryBean(){
        ApplicationContext context =  new ClassPathXmlApplicationContext("beanFactory.xml");
        Course course = context.getBean("myBean", Course.class);
        System.out.println(course);
    }

    @Test
    public void testOrders(){
//        ApplicationContext context =  new ClassPathXmlApplicationContext("beanOrder.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanOrder.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println("④ 创建bean实例对象");
        System.out.println(orders);
//        手动销毁bean实例
        context.close();

    }

}
