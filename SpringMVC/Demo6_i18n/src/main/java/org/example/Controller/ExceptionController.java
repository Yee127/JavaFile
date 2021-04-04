package org.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 处理异常:
 * 通过@ExceptionHandler可以在方法中记录日志
 * 转发一个友好的界面进行提示:
 * 经验: 1. 记录日志中
 *      2.可以将异常转发错误也没， 将错误信息在一个隐藏的div中
 * 如果@ExceptionHandler写在@Controller中只能处理当前控制器类的处理方法
 */
@Controller
public class ExceptionController {
    @RequestMapping("/exception")
    public String exception1(@RequestParam("name") String name){
        System.out.println("方法处理1~~~~~");
        return "exception";
    }


    @RequestMapping("/exception2")
    public String exception2(@RequestParam("name") String name){
        System.out.println("方法处理2~~~~~");
        return "exception";
    }
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("e",e);
        System.out.println(e.getMessage());
        return modelAndView;
    }
}
