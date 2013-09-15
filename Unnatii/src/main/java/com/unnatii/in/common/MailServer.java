package com.unnatii.in.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("mailServer")
public class MailServer {
    
    @Autowired
    private MailSender mailSender;
    @Autowired
    private SimpleMailMessage alertMailMessage;
    
    public void sendMail(String from, String to, String subject, String body) {
        
        SimpleMailMessage message = new SimpleMailMessage();
         
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
        
    }
    
    public void sendAlertMail(String alert) {
        
        SimpleMailMessage mailMessage = new SimpleMailMessage(alertMailMessage);
        mailMessage.setText(alert);
        mailSender.send(mailMessage);
        
    }
    
}