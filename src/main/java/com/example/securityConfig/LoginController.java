package com.example.securityConfig;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping(value = {"/login1"}, method = RequestMethod.GET)
    public String login() {
        return "admin/login";

    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    @ResponseBody
    public String logout() {
        SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
        return "Wylogowano";

    }
}
