package com.example.mail;

import org.springframework.web.bind.annotation.RequestParam;

public interface EmailService {
    void sendSimpleMail(@RequestParam String receiver, @RequestParam String subject, @RequestParam String message);
}
