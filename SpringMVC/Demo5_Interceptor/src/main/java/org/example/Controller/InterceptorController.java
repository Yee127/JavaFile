package org.example.Controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class InterceptorController {
    @RequestMapping("/test01")
    public String test01(){
        System.out.println("请求方法执行中....");
        return "admin";
    }

    @PostMapping("/login")
    public String login(HttpSession session){
        session.setAttribute("user","admin");
        return "admin";
    }
    @GetMapping("/login")
    public String login()
    {
        return "login";
    }
}
