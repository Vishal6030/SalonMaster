package com.admin.salonmaster.serviceImpl;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailService {

    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;


    public void sendSimpleMail(String to, String subject, String content) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setFrom("Krati Infotech <" + sender + ">");
            helper.setTo(to.toLowerCase());
            helper.setSubject(subject);
            helper.setText(content, true);
            javaMailSender.send(mimeMessage);
            System.out.println("Email Sent Successfully...");
        } catch (MessagingException e) {

        }
    }
}
