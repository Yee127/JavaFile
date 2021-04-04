package org.example.interceptor;

import org.omg.PortableInterceptor.Interceptor;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 在方法：
     *  @PostMapping("/login")
     *     public String login(HttpSession session){
     *
     * //        session.setAttribute("user","admin");
     *         Object user = session.getAttribute("user");
     *         Object password = session.getAttribute("password");
     *         if (user=="admin" && password=="123456")
     *         {
     *             return "admin";
     *         }else {
     *             System.out.println("用户名或者密码有误");
     *             return "login";
     *         }
     *     }
     *     之前执行 判断是否为空
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
//        没有登录就进行拦截
        if (StringUtils.isEmpty(request.getAttribute("user"))){
            response.sendRedirect(request.getContextPath()+"/login");
            System.out.println("用户名为空！");
            return false;
        }
        else {
            return true;
        }
    }
}
