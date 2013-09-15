package com.unnatii.in.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MailServiceTest {

    public static void main(String[] args) {
        
        ApplicationContext context = new FileSystemXmlApplicationContext("servlet-context.xml");

        MailServer mailService = (MailServer) context.getBean("mailService");
        
        mailService.sendMail("koushik08oct@gmai.com", "koushik25sep@hotmail.com", "Testing123", "Testing only \n\n Hello Spring Email Sender");
        
        mailService.sendAlertMail("Exception occurred");
        
    }
}