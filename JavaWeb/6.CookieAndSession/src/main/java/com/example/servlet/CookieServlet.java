package com.example.servlet;

import com.example.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet{
    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("Path1","path1");
        //getContestPath()  ===> 获取工程路径名
        cookie.setPath(req.getContextPath()+"/abc");
        resp.addCookie(cookie);
        resp.getWriter().write("带有/abc的工程Path的Cookie已经创建！");
    }
    /**
     * 默认会话级别的cookie
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("defalutLife","defaultLife"); cookie.setMaxAge(-1);//设置存活时间 resp.addCookie(cookie);
    }
    /**
     * 立即删除
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Cookie cookie =CookieUtils.findCookie("key2",req.getCookies());
        if (cookie != null){
            //调用setmMaxAge(0)
            cookie.setMaxAge(0); // 0 立即删除
            resp.addCookie(cookie);
            resp.getWriter().write("key2已被删除！");
        }
    }
    /**
     * 设置存活一小时的cookie
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void saveTime(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Cookie cookie = new Cookie("save3600","3600");
        cookie.setMaxAge(3600);
        resp.addCookie(cookie);
        resp.getWriter().write("创建了一个存活一小时的cookie");
    }

    /**
     * 修改cookie
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//        方案一:
//        1、先创建一个要修改的同名的 Cookie 对象
//        2、在构造器，同时赋于新的 Cookie 值。
//        Cookie cookie = new Cookie("key1","newValue1");
//        3、调用 response.addCookie( Cookie ); 通知 客户端 保存修改
//        resp.addCookie(cookie);

//
//        方案二:
//        1、先查找到需要修改的 Cookie 对象
        Cookie cookie = CookieUtils.findCookie("key2", req.getCookies());
        if (cookie != null) {
//            2、调用 setValue()方法赋于新的 Cookie 值。
            cookie.setValue("newValue2");
//            3、调用 response.addCookie()通知客户端保存修改
            resp.addCookie(cookie);
        }
    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            // getName 方法返回 Cookie 的 key(名)
            // getValue 方法返回 Cookie 的 value 值
            resp.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "] <br/>");
        }
        Cookie iWantCookie = CookieUtils.findCookie("key1", cookies);

        // 如果不等于 null，说明赋过值，也就是找到了需要的 Cookie if (iWantCookie != null) {
        resp.getWriter().write("找到了需要的 Cookie");

    }


    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("key1","v1");
        resp.addCookie(cookie);
        Cookie cookie1 = new Cookie("key2","v2");
        resp.addCookie(cookie1);
        resp.getWriter().write("Cookie has been created successfully!");
    }
}
