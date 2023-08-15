package com.example.mail;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class Service1 {

    private final JavaMailSender javaMailSender;

    public Service1( JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String to, String subject, String text) {
    	try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);
            helper.setFrom("authorisedgeneratedmail@gmail.com", "One-Time-PassWord(by HVG)");

            javaMailSender.send(message);
        } catch (Exception e) {
             e.printStackTrace();
        }
    }
}
