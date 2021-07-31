package com.example.email;

public interface EmailSender {
    void sendEmail(String to, String subject, String content);
}
