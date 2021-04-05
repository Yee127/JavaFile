package com.book.Web;

import com.book.Pojo.User;
import com.book.Service.UserService;
import com.book.Service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {
    private UserService userService =new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        String CODE = "abcde";
        //                用于回传的
        req.setAttribute("email",email);
        req.setAttribute("username",username);
//        2、检查 验证码是否正确  === 写死,要求验证码为:abcde
        if (CODE.equalsIgnoreCase(code)){
//            3、检查 用户名是否可用
            if (userService.existUsername(username)){
//                已存在不可用
                System.out.println("用户名[" + username + "]已存在!");
//                消息提示消息
                req.setAttribute("msg","用户名已存在");

//        跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);

            }else {
                //      可用
//                调用Sservice保存到数据库
                userService.registUser(new User(null,username,password,email));
                System.out.println(username+"注册成功！");
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);

            }

        }else {
            System.out.println("验证码"+code+"有误！");
            req.setAttribute("msg", "验证码错误！！");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }
}
