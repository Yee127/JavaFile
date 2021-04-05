package org.example.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
public class i18nController {
    @RequestMapping("/i18n/{language}_{country}")
    public String locale(@PathVariable("language") String language,
                         @PathVariable("country") String country,
                         HttpServletRequest request,
                         HttpServletResponse response,
                         @Autowired SessionLocaleResolver localeResolver){
        Locale locale1 = new Locale(language,country);
        localeResolver.setLocale(request,response,locale1);
        return "login";
    }
}
