package com.mendesapp.weathermap.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void enviarEmail(String to, String mensagem) {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(to);
        mail.setSubject("Clima Atual 🌤️");
        mail.setText(mensagem);

        mailSender.send(mail);
    }
}