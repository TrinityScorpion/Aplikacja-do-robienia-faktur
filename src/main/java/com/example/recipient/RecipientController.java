package com.example.recipient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/recipient")
@RequiredArgsConstructor
public class RecipientController {

    private final RecipientService recipientService;

    @GetMapping("/all")
    public String getAll(Model model){
         model.addAttribute("recipientList", recipientService.getAll());
         return "";
    }

    @GetMapping("/add")
    public String add(Model model, Principal principal){
        String username = principal.getName();
        model.addAttribute("username", username);
        model.addAttribute("recipient", new Recipient());
        return "/recipient/forms";
    }

    @PostMapping("/add")
    public String add(@Valid Recipient recipient, BindingResult result){
        if(result.hasErrors()){
            return "/recipient/forms";
        }
        recipientService.saveRecipient(recipient);
        return "redirect:/invoice/all";
    }

}
