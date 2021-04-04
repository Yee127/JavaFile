package com.mvc.controller;

import com.mvc.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Controller
//@RestController               //相当于控制器类中所有的处理方法都加上了@ResponseBody
public class JsonController {

    @RequestMapping("/json")
    @ResponseBody     //将返回值作为文本进行返回，并不是返回视图逻辑名称
    public Person responceJson(){
        Person person = new Person(1, "Tom","AAAAA",new Date("2222/02/22"));
        return person;
    }
}
