package com.example.email;

import com.example.user.User;
import com.example.user.UserRepository;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.codec.CharEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TransferQueue;

@Controller
public class UserEmailService implements EmailSender{

    @Autowired
    UserRepository repo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender mailSender;

    public void register(User user, String siteURL)
            throws UnsupportedEncodingException, MessagingException {
        String encodedPassword = passwordEncoder.encode("fsfsdf");
        user.setPassword(encodedPassword);
        String randomCode = RandomString.make(64);
        user.setUsername("Maniudsss");
        user.setEnabled(1);
//        repo.save(user);
        sendVerificationEmail(user, siteURL);
    }

    private void sendVerificationEmail(User user, String siteURL)
            throws MessagingException, UnsupportedEncodingException {
        String toAddress = "mariusz.kepa.h3@wp.pl";
        String fromAddress = "mariusz.kepa.h3@wp.pl";
        String senderName = "Your company name";
        String subject = "Please verify your registration";
        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "Your company name.";
        FileSystemResource file = new FileSystemResource(new File("Invoice-Template.docx"));
        MimeBodyPart attachmentPart = new MimeBodyPart();
        try {
            attachmentPart.attachFile(new File("Invoice-Template.docx"));

        } catch (IOException e) {
            e.printStackTrace();
        }



        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, CharEncoding.UTF_8);
        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(attachmentPart);
        message.setContent(multipart);

        helper.addAttachment("Invoice-Template.docx", file);
        content = content.replace("[[name]]", user.getUsername());
        String verifyURL = siteURL + "/verify?code=" + user.getPassword();
        content = content.replace("[[URL]]", verifyURL);
        helper.setText(content, true);
        mailSender.send(message);
    }
    @Override
    public void sendEmail(String to, String title, String content) {
        MimeMessage mail = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setReplyTo("mariusz.kepa.h3@wp.pl");
            helper.setFrom("mariusz.kepa.h3@wp.pl");
            helper.setSubject(title);
            helper.setText(content, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        mailSender.send(mail);
    }
}
