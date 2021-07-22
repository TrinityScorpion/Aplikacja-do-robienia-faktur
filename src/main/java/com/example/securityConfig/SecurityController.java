package com.example.securityConfig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecurityController {

    @GetMapping("/")
    @ResponseBody
    public String home(){
        return "home";
    }

    @GetMapping("/about")
    @ResponseBody
    public String about(){
        return "Here you can find some details for logged users";
    }

}
