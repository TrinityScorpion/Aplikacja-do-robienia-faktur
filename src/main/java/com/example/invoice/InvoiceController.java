package com.example.invoice;


import com.example.CodersLabLastProject.FileInvoice;
import com.example.email.UserEmailService;
import com.example.recipient.Recipient;
import com.example.recipient.RecipientService;
import com.example.sender.Sender;
import com.example.sender.SenderService;
import com.example.user.User;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import javax.validation.Valid;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Controller
@RequiredArgsConstructor
@RequestMapping("/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final RecipientService recipientService;
    private final SenderService senderService;
    private final UserEmailService userEmailService;

    @ModelAttribute("recipientList")
    public List<Recipient> getRecipients() {
        return recipientService.getAll();
    }

    @ModelAttribute("senderList")
    public List<Sender> getSenders() {
        return senderService.getAll();
    }


    @GetMapping("/all")
    public String getAll(Model model, Principal principal) {
        String username = principal.getName();
        model.addAttribute("username", username);
        model.addAttribute("invoiceList", invoiceService.getAll());
        return "/invoice/list";
    }

    @GetMapping("/add")
    public String add(Model model, Principal principal) {
        Invoice invoice = new com.example.invoice.Invoice();
        String username = principal.getName();
        model.addAttribute("username", username);
        model.addAttribute("invoice", invoice);
        return "/invoice/forms";
    }

    @PostMapping("/add")
    public String add(@Valid Invoice invoice, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result);
            return "/invoice/forms";
        }
        Random rand = new Random();
        int number = rand.nextInt(100000);
        invoice.setCreated(LocalDate.now());
        invoice.setDeadline(LocalDate.of(2021, 07, 30));
        String invoiceNumber1 = number + "_" + LocalDate.now().getYear()
                + LocalDate.now().getMonthValue()
                + LocalDate.now().getDayOfMonth();
        invoice.setInvoiceNumber(invoiceNumber1);
        invoiceService.createInvoice(invoice);
        return "redirect:/invoice/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        com.example.invoice.Invoice invoice = invoiceService.findById(id);
        System.out.println(invoice.getInvoiceNumber());
        invoiceService.delete(id);
        return "redirect:/invoice/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("invoice", invoiceService.findById(id));
        return "/invoice/forms";
    }

    @PostMapping("/edit/{id}")
    public String edit(Invoice invoice) {
        invoice.setCreated(LocalDate.now());
        invoiceService.update(invoice);
        return "redirect:/invoice/all";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable long id, Model model, Principal principal) throws IOException {
        String username = principal.getName();
        model.addAttribute("username", username);
        Invoice invoice = invoiceService.findById(id);
        double sum = invoice.getQuantity() * invoice.getSalary();
        double tax = sum * (invoice.getTax() / 100.0);
        double total = sum + tax;
        //-------Invoice---------//
        model.addAttribute("invoiceObject", invoice);
        model.addAttribute("tableViewTotalTax", tax);
        model.addAttribute("tableViewTotalMoney", total);
        model.addAttribute("tableViewSum", sum);


        //-------File Replacer--------//
        String input = "Invoice-Template.docx";
        String output = "test3.docx";
        XWPFDocument doc = new XWPFDocument(
                Files.newInputStream(Paths.get(input)));
        FileInvoice fileInvoice = new FileInvoice();
        fileInvoice.updateDocument(doc, invoice.getRecipient().getRecipientCompany(), "${company}");
        fileInvoice.updateDocument(doc, invoice.getRecipient().getRecipientCity(), "${city}");
        fileInvoice.updateDocument(doc, invoice.getRecipient().getRecipientCountry(), "${country}");

        fileInvoice.updateDocument(doc, invoice.getInvoiceNumber(), "${invoiceN}");
        fileInvoice.updateDocument(doc, invoice.getCreated() + "", "${created}");
        fileInvoice.updateDocument(doc, invoice.getDeadline() + "", "${deadline}");

        fileInvoice.updateDocument(doc, invoice.getSender().getCompanyName() + " / " + invoice.getSender().getOwnerName(), "${companyName}");
        fileInvoice.updateDocument(doc, invoice.getSender().getCompanyAdress(), "${companyAdress}");
        fileInvoice.updateDocument(doc, invoice.getSender().getCity(), "${companyCity}");
        fileInvoice.updateDocument(doc, invoice.getSender().getCountry(), "${companyCountry}");
        fileInvoice.updateDocument(doc, invoice.getSender().getCompanyPhone(), "${companyPhone}");
        fileInvoice.updateDocument(doc, "111-111-111", "${privatePhone}");
        fileInvoice.updateDocument(doc, invoice.getSender().getOwnerName(), "${ownerName}");

        fileInvoice.updateDocument(doc, invoice.getDescription(), "${description}");
        fileInvoice.updateDocument(doc, invoice.getQuantity() + "", "${quan}");
        fileInvoice.updateDocument(doc, invoice.getSalary() + "", "${salary}");
        fileInvoice.updateDocument(doc, sum + "", "${sum}");
        fileInvoice.updateDocument(doc, invoice.getTax() + "", "${taxR}");
        fileInvoice.updateDocument(doc, tax + "", "${taxT}");
        fileInvoice.updateDocument(doc, total + "", "${Total}");

        try (FileOutputStream out = new FileOutputStream(output)) {
            doc.write(out);
        }
        return "/invoice/view";
    }

    @GetMapping("/email")
    public String email(User user, HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
       userEmailService.register(user, getSiteURL(request));

        return "redirect:/invoice/all";
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

    @GetMapping("/save")
    public String save(){
        try{
            JFrame parentFrame = new JFrame();

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Specify a file to save");

            int userSelection = fileChooser.showSaveDialog(parentFrame);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                System.out.println("Save as file: " + fileToSave.getAbsolutePath());
            }
        }catch(HeadlessException e){
            System.out.println(e.getMessage());
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }

        return "redirect:/invoice/all";
    }

}


