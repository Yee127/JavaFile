package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/HelloController")
public class HelloController {
    @RequestMapping("/hello")
    public String Hello(Model model){
        model.addAttribute("msg","This is a SpringMVC program of annotation！");
        return "hello";
    }
}
