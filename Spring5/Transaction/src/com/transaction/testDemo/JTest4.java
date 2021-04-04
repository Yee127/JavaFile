package com.transaction.testDemo;

import com.transaction.service.TranService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)   //单元测试框架
@ContextConfiguration("classpath:beanJdbc.xml")   // 加载配置文件
public class JTest4 {
    @Autowired
    private TranService service;
    @Test
    public void test1(){
        service.accountMoney();
    }
}
