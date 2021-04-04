package com.book.Web;

import com.book.Pojo.User;
import com.book.Service.UserService;
import com.book.Service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User loginUser = userService.login(new User(null, username, password, null));
        if (loginUser == null){
            System.out.println("用户名或者密码不正确！");
            req.setAttribute("msg","用户名或者密码不正确！");
            req.setAttribute("username",username);

            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);

        }else {
            System.out.println("登录成功");
//            跳转成功页面
            req.getRequestDispatcher("pages/user/login_success.jsp").forward(req,resp);
        }

    }
}
