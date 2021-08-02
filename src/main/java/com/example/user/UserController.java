package com.example.user;

import lombok.Data;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@Data
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "/invoice/login";
    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public String logout() {
        SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
        return "/admin/logout";
    }

    @GetMapping("/create-user")
    public String createUser(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "invoice/register";
    }

    @PostMapping("/create-user")
    public String createUser(@Valid User user, BindingResult result){
        if (result.hasErrors()) {
            System.out.println(result);
            return "invoice/register";
        }
        if(user.getPassword().equals(user.getConfirmPassword())){
            user.setEnabled(1);
            userService.saveUser(user);
        }else{
            System.out.println("Password are not equals");
        }
        return "redirect:/user/create-user";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        return "Hello " + entityUser.getUsername();
    }
}
