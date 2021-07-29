package com.example.CodersLabLastProject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    @RequestMapping(value = "/home")
    public String home(){
        return "/dashboard/home";
    }
}
