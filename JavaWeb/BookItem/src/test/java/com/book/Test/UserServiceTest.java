package com.book.Test;

import com.book.Pojo.User;
import com.book.Service.UserService;
import com.book.Service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

class UserServiceTest {
    UserService userService = new UserServiceImpl();
    @Test
    void registUser() {
        userService.registUser(new User(null,"AAA","123456","aaa@126.com"));
    }

    @Test
    void login() {
        User user = userService.login(new User(null, "wzg168", "123456", null));
        System.out.println(user);
    }

    @Test
    void existUsername() {
        if (userService.existUsername("wzg16888")) {
            System.out.println("用户名已存在！");
        } else {
            System.out.println("用户名可用！");
        }
    }
}