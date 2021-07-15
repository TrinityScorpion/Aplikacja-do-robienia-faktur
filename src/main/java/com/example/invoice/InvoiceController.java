package com.example.invoice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @RequestMapping("/all")
    @ResponseBody
    public String getAll(Model model){
        model.addAttribute("invoiceList", invoiceService.getAll());
        return "/invoice/list";
    }

}


