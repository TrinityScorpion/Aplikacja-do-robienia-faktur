package com.example.invoice;

import com.example.recipient.Recipient;
import com.example.recipient.RecipientService;
import com.example.sender.Sender;
import com.example.sender.SenderService;
import com.sun.xml.internal.org.jvnet.mimepull.MIMEMessage;
import jogamp.opengl.glu.nurbs.Bin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final RecipientService recipientService;
    private final SenderService senderService;

    @ModelAttribute("recipientList")
    public List<Recipient> getRecipients(){
        return recipientService.getAll();
    }

    @ModelAttribute("senderList")
    public List<Sender> getSenders(){
        return senderService.getAll();
    }


    @GetMapping("/all")
    public String getAll(Model model){
        model.addAttribute("invoiceList", invoiceService.getAll());
        return "/invoice/list";
    }

    @GetMapping("/add")
    public String add(Model model){
        Invoice invoice = new Invoice();
        model.addAttribute("invoice", invoice);
        return "/invoice/forms";
    }

    @PostMapping("/add")
    public String add(@Valid Invoice invoice, BindingResult result){
        if(result.hasErrors()){
            return "/invoice/forms";
        }
        invoice.setCreated(LocalDate.now());
        invoice.setDeadline(LocalDate.of(2021,07,30));
        invoiceService.createInvoice(invoice);
        return "redirect:/invoice/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        Invoice invoice = invoiceService.findById(id);
        System.out.println(invoice.getInvoiceNumber());
        invoiceService.delete(id);
        return "redirect:/invoice/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("invoice", invoiceService.findById(id));
        return "/invoice/forms";
    }

    @PostMapping("/edit/{id}")
    public String edit(Invoice invoice){
        invoice.setCreated(LocalDate.now());
        invoiceService.update(invoice);
        return "redirect:/invoice/all";
    }


}


