package com.example.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String getMail() {
        return "send";
    }

    @PostMapping("/")
    public String sendMail(@RequestParam String receiver, @RequestParam String subject, @RequestParam String message) {
        emailService.sendSimpleMail(receiver, subject, message);
        return "send";
    }
}
