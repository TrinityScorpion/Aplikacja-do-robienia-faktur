package com.example.securityConfig;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecuredController {

    @GetMapping("/secured1")
    @Secured("ROLE_ADMIN")
    @ResponseBody
    public String secured1(){
        return "/admin/test1";
    }

    @Secured("ROLE_USER")
    @GetMapping("/secured")
    public String user() {
        return "/admin/test";
    }

    @GetMapping("/secured2")
    @Secured("ROLE_ADMIN")
    @ResponseBody
    public String secured2(){
        return "/admin/test2";
    }

    @GetMapping("/secured3")
    @Secured("ROLE_ADMIN")
    @ResponseBody
    public String secured3(){
        return "/admin/test3";
    }
}
