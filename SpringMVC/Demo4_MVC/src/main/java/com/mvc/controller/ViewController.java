package com.mvc.controller;

import com.mvc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class ViewController {
    @RequestMapping(value = "/user")
    public String user(Map<String,Object> map){
        map.put("user",new User());
        return "form";
    }

    @RequestMapping(value = "/showUser")
    public String showForm(Map<String,Object> map ,
                           User user){

        map.put("user",user);
        System.out.println(user);
        return "showForm";
    }
}
