package org.example.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

public class MyInterceptor implements HandlerInterceptor {
    /**
     * 方法之前执行    ```````````````````````````````````````````````````````````````````````
     * @param request   可以方法请求进来之前更改Request中的属性值
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = null;
        if(handler instanceof HandlerMethod){
           handlerMethod =(HandlerMethod) handler;
       }
        System.out.println("——————————————————————————————————————————————————\n"
                +"Class:"+handlerMethod.getBean().getClass().getName()+"\n"
                +"Function:"+handlerMethod.getMethod().getName()+"\n"
                +"Parameter:"+ Arrays.toString(handlerMethod.getMethod().getParameters())+"\n"
                +"前执行了-------> preHandle\n——————————————————————————————————————————————————");
        return true;
    }

    /**
     *如果preHandle返回false则会不会允许该方法
     * 在请求执行后执行，在视图渲染之前执行
     * 当处理方法出现了异常则不会执行方法
     * @param request
     * @param response       可以在方法执行后去更改response中的信息
     * @param handler        封装了当前处理方法的信息
     * @param modelAndView   封装了model和view，所以当请求结束后可以修改model中的数据或者新增model数据，也 可以修改view的
     * @throws Exception
     */
    @Override
    public void postHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("方法之后执行，在渲染之前>>>>>>>> postHandle ");
    }

    /**
     *如果preHand1e返回false则会不会允许该方法
     * 在视图渲染之后执行，相当于try catch finally 中finally, 出现异常也一定会执行该方法
     * @param request
     * @param response
     * @param handler
     * @param ex  Exception对象，在该方法中去做一些:记录异常日志的功能，或者清除资源
     * @throws Exception
     */
    @Override
    public void afterCompletion(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("在视图之后>>>>>>>> afterCompletion ");
    }
}
