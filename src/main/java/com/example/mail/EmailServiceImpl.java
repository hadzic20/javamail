package com.example.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}") private String sender;

    public void sendSimpleMail(String receiver, String subject, String message)
    {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(sender);
            mailMessage.setTo(receiver);
            mailMessage.setText(message);
            mailMessage.setSubject(subject);

            javaMailSender.send(mailMessage);
        }

        catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
