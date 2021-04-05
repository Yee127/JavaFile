package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("admin".equals(username) && "admin".equals(password)){
            Cookie cookie_name = new Cookie("username",username);
            Cookie cookie_pwd  = new Cookie("password",password);
            cookie_name.setMaxAge(3600);
            cookie_pwd.setMaxAge(3600);
            resp.addCookie(cookie_name);
            resp.addCookie(cookie_pwd);
            System.out.println("Login!");
        }else {
            System.out.println("Error!");
        }
    }
}
