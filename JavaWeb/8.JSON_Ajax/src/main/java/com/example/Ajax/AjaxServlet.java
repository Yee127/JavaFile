package com.example.Ajax;

import com.example.Bean.Person;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxServlet extends BaseServlet {
    protected void getJson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Use getJSON function ");
        Person person = new Person("Tom", 11);

        Gson gson =new Gson();
        String json = gson.toJson(person);

        resp.getWriter().write(json);
    }
}
