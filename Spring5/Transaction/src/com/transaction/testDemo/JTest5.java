package com.transaction.testDemo;


import com.transaction.service.TranService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:beanJdbc.xml")

//复合注解替代上面两个注解完成整合
@SpringJUnitConfig(locations = "classpath:beanJdbc.xml")
public class JTest5 {
    @Autowired
    private TranService service;
    @Test
    public void test1(){
        service.accountMoney();
    }
}
