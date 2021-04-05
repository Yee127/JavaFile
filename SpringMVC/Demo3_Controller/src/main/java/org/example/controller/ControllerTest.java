package org.example.controller;

import org.example.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.Map;

@Controller
public class ControllerTest {

//method：限定请求方式
//    常用：
//        get、post
//        method = RequestMethod.POST : 只接受这种类型的请求
//            4xx ： 客户端错误
//                405 - Request method 'GET' not supported
    @RequestMapping(value = "/method",method = RequestMethod.POST)
    public String info1(){
        System.out.println("method");
        return "hello";
    }
//    params:规定请求参数
//    @RequestMapping(value = "/params",params ={"username"})
//    @RequestMapping(value = "/params",params ={"!username"})   "!" ： 非
//    @RequestMapping(value = "/params",params ={"username=111"})
//    指定多个参数
    @RequestMapping(value = "/params",params ={"username=111","pwd","!age"})
    public String params(){
        System.out.println("params");
        return "hello";
    }
//    Mozilla/5.0 (Macintosh; Intel Mac OS X 11_2_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.82 Safari/537.36
//   headers ： 设置请求头参数 指定的（浏览器）才可以访问
    @RequestMapping(value = "/headers",headers = "User-Agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 11_2_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.82 Safari/537.36")
    public String info(){
        System.out.println("headers");
        return "hello";
    }

//    consumes:
//    produces:
//


//    ——————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————

    /**
     *
     * Ant风格：（精确优先！）
     *      ？仅仅只匹配一个字符
     *      * 匹配 任意多个字符 或 一层路径
     *      ** 匹配多层路径
     *
     */
//    ？仅仅只匹配一个字符
    @RequestMapping(value = "/antTest01")
    public String Ant1(){
        System.out.println("-----> Ant1");
        return "hello";
    }
    @RequestMapping(value = "/antTest0？")
    public String Ant2(){
        System.out.println("-----> Ant？");
        return "hello";
    }
//    * 匹配任意多个字符
    @RequestMapping(value = "/antTest0*")
    public String Ant3(){
        System.out.println("-----> Ant*");
        return "hello";
    }
    @RequestMapping(value = "/a/*/antTest0")
    public String Ant4(){
        System.out.println("-----> Ant*");
        return "hello";
    }
    @RequestMapping(value = "/a/**/antTest0")
    public String Ant5(){
        System.out.println("-----> Ant**");
        return "hello";
    }

    @RequestMapping("/add/{a}/{b}")
    public String add(@PathVariable int a,@PathVariable("a") int b, Model model){
        int res = a+b;
        model.addAttribute("msg",res);
        return "hello";
    }

//——————————————————————————————————————————————————————————————————————————————————
    /**
     *
     * @RequestParam 获取请求参数
     *
     * @RequestHeader 获取请求头参数
     *
     * @CookieValue 获取cookie参数
     *
     * 以上三者默认必须携带value   但通过 required = false 可设置不是必须携带！
     */

    @RequestMapping(value = "/RRC")
    public String requestParam(@RequestParam(value = "username",required = false) String user,
                               @RequestHeader(value = "User-Agent") String Agent,
                               @CookieValue(value = "JSESSIONID") String id, Model model){
        System.out.println("Username="+ user);
        System.out.println("User-Agent=" + Agent);
        System.out.println("JSESSIONID=" + id);
        model.addAttribute("user",user);
        model.addAttribute("Agent",Agent);
        model.addAttribute("id",id);
        return "success";
    }
    //——————————————————————————————————————————————————————————————————————————————————
    @ModelAttribute
    public void getUser(@RequestParam(value = "id",required = false) Integer id,
                        Map<String,Object> map){
        System.out.println("modelAttribute method");
        if (id != null){
            User user = new User(1,"Tom",13);
            System.out.println("模拟数据库内的原始内容：user:" + user);
            map.put("user",user);
        }

    }

    @RequestMapping("/MA")
    public String test(User user){
        System.out.println("Update:"+ user);
        return "success";
    }



}
