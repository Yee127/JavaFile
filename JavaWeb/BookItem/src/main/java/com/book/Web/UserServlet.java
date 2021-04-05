package com.book.Web;


import com.book.Pojo.User;
import com.book.Service.UserService;
import com.book.Service.impl.UserServiceImpl;
import com.book.Utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    /**
     * logout
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1、销毁 Session 中用户登录的信息(或者销毁 Session)
        req.getSession().invalidate();
//        2、重定向到首页(或登录页面)。
        resp.sendRedirect(req.getContextPath());
    }

    /**
     * 处理登录的功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //  1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 调用 userService.login()登录处理业务
        User loginUser = userService.login(new User(null, username, password, null));
        // 如果等于null,说明登录 失败!
        if (loginUser == null) {
            // 把错误信息，和回显的表单项信息，保存到Request域中
            req.setAttribute("msg", "用户或密码错误！");
            req.setAttribute("username", username);
            //   跳回登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            // 登录 成功
//            保存用户登录信息到session
            req.getSession().setAttribute("user",loginUser);
            //跳到成功页面login_success.html
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }

    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       获取session中验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
//        删除验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        //  1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        String CODE = "abcde";

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        System.out.println("User:"+user);
        //                用于回传的
        req.setAttribute("email",email);
        req.setAttribute("username",username);
//        2、检查 验证码是否正确  === 写死,要求验证码为:abcde
        if (token != null && token.equalsIgnoreCase(code)){
//            3、检查 用户名是否可用
            if (userService.existUsername(username)){
//                已存在不可用
                System.out.println("用户名[" + username + "]已存在!");
//                消息提示消息
                req.setAttribute("msg","用户名已存在");

//        跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);

            }else {
                //      可用
//                调用Sservice保存到数据库
                userService.registUser(new User(null,username,password,email));
                System.out.println(username+"注册成功！");
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);

            }

        }else {
            System.out.println("验证码"+code+"有误！");
            req.setAttribute("msg", "验证码错误！！");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }
}
