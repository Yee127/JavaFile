package com.example.Filter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        //        获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //        登录判断
        if ("admin".equals(username) && "admin".equals(password)){
            req.getSession().setAttribute("username",username);
            resp.getWriter().write("Login Succeed "+"<br>"+"请点击 :<a href=\"http://localhost:8888/7_Filter/admin/test1.jsp\">跳转</a> ");

        }else {
            req.getRequestDispatcher("http://localhost:8888/7_Filter/user/login.jsp").forward(req,resp);
        }
    }
}
