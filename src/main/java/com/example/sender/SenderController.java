package com.example.sender;

import com.example.recipient.Recipient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/sender")
public class SenderController {

    private final SenderService senderService;

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("sender", new Sender());
        return "/sender/forms";
    }

    @PostMapping("/add")
    public String add(@Valid Sender sender, BindingResult result){
        if(result.hasErrors()){
            return "/sender/forms";
        }
        senderService.saveSender(sender);
        return "redirect:/invoice/all";
    }

}
