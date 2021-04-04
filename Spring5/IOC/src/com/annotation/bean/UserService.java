package com.annotation.bean;

import com.annotation.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    /**
     * (1)@Autowired:根据属性类型进行自动装配
     * (2)@Qualifier:根据名称进行注入
     *               这个@Qualifier 注解的使用，和上面@Autowired 一起使用
     * (3)@Resource:可以根据类型注入，可以根据名称注入
     * - @Resource 根据类型进行注入
     * - @Resource(name = "userDaoImpl1") //根据名称进行注入
     * (4)@Value:注入普通类型属性
     */


    //添加注入属性注解
    @Autowired //根据类型进行注入
//    @Qualifier(value = "userDaoImpl1") //根据名称进行注入
    private UserDao userDao;


    @Value(value = "Tom")
    private String name;
    public void add(){
        System.out.println("Service add....");
        userDao.update();
    }

    @Override
    public String toString() {
        return "UserService{" +
                "\nuserDao=" + userDao +
                ", \nname='" + name + '\'' +
                '}';
    }

    public void info(){
        add();
    }
}
