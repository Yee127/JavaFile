package org.example.Controller;

import org.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Locale;


@Controller
public class UserController {
    @Autowired
    MessageSource messageSource;
    @RequestMapping("/i18n")
    public String check(@Valid User user, BindingResult result, Model model, Locale locale){

        if (result.hasErrors()){
            return "login";
        }
        System.out.println("user.getUsername()=="+user.getUsername());
//        验证用户名或者密码是否正确
        if (!user.getUsername().equals("admin") &&
        !user.getPassword().equals("admin")){
            model.addAttribute("errorMsg",messageSource.getMessage("loginError",null,locale));
            return "login";
        }
        model.addAttribute("user",new User());
        model.addAttribute("username",user.getUsername());
        return "admin";
    }
}
