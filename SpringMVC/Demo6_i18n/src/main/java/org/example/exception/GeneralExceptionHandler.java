package org.example.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 处理全局异常：
 *
 */
@ControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView handleexception(Exception e){
        System.out.println("全局异常处理！");
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("e",e);
        return modelAndView;
    }
}
