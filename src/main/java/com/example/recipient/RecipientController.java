package com.example.recipient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipient")
@RequiredArgsConstructor
public class RecipientController {

    private final RecipientService recipientService;

    @RequestMapping("/all")
    public String getAll(Model model){
         model.addAttribute("recipientList", recipientService.getAll());
         return "/home";
    }
}
