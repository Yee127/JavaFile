package com.example.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Config extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("重写init.....");
    }
}
