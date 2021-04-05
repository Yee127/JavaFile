package com.aop.JDK_Agent.proxy;

import com.aop.JDK_Agent.bean.UserDao;
import com.aop.JDK_Agent.bean.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy {
    public static void main(String[] args) {
        Class[] interfaces = {UserDao.class};

        UserDaoImpl userDao = new UserDaoImpl();
        UserDao dao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        int result = dao.add(1, 2);
        System.out.println("result:"+result);

    }


}


//创建代理对象代码
class UserDaoProxy implements InvocationHandler{
//    创建被代理的对象
//    有参构造
    private Object obj ;
    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }

    // 增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before>>>>>"+method.getName()+":传递的参数："+ Arrays.toString(args));
        Object res = method.invoke(obj, args);
        System.out.println("After:"+obj);
        return res;
    }
}