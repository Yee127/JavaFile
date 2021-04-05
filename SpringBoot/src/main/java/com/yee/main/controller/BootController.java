package com.yee.main.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BootController {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello SpringBoot ";
    }

}
