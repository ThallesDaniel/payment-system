package com.thallesdaniel.paymentsystem.service;

import com.thallesdaniel.paymentsystem.entity.User;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class MailService {
    @Autowired
    private JavaMailSender emailSender;
    private String verifyURL = "http://localhost:8080/user/verify?code=";
    public void sendVerificationEmail(User user) throws MessagingException, UnsupportedEncodingException {
        String toAddres = user.getEmail();
        String fromAddres = "batata18cm88@gmail.com";
        String sendName = "Teste";
        String subject = "Pleace Verify your Registration";
        String content = "";
    }
}
