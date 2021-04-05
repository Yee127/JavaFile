package com.aop.AspectJAnnotation.bean;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserProxy {
    @Before(value = "pointCut()")
    public void before(){
        System.out.println(" 前置通知 ");
    }
    @AfterReturning(value = "execution(* com.aop.AspectJAnnotation.bean.User.add(..))")
    public void afterReturning(){
        System.out.println(" 后置通知 ");
    }
    @After(value = "execution(* com.aop.AspectJAnnotation.bean.User.add(..))")
    public void after(){
        System.out.println(" 最终通知 ");
    }

    @AfterThrowing(value = "execution(* com.aop.AspectJAnnotation.bean.User.add(..))")
    public void afterThrowing(){
        System.out.println(" 异常通知 ");
    }

    @Around(value = "execution(* com.aop.AspectJAnnotation.bean.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println(" 环绕之前 ");
        //被增强的方法执行
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println(" 环绕之后 ");

    }
    @Pointcut(value = "execution(* com.aop.AspectJAnnotation.bean.User.add(..))")
    public void pointCut(){

    }

}
