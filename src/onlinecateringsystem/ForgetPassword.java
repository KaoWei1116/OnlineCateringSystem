/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinecateringsystem;

import entity.Email;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author tzeha
 */
public class ForgetPassword {
    
    
     public String getRandom(){
        Random rnd = new Random();
        int number=rnd.nextInt(999999);
        return String.format("%06d", number);
    }
    
      public boolean sendEmail(Email email){
        boolean test= false;
        
        String toEmail = email.getGmail();
        String fromEmail="tzehaoheng3083@gmail.com";
        String password="tzehao_0131";
        
        try{
            Properties pr = new Properties();
            pr.setProperty("mail.smtp.host", "smtp.gmail.com");
            pr.setProperty("mail.smto.port", "587");
            pr.setProperty("mail.smtp.auth", "true");
            pr.setProperty("mail.smtp.starttls.enable", "true");
            pr.put("mail.smtp.socketFactory.port", "587");
            pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            
             Session session = Session.getInstance(pr, new Authenticator(){
                 @Override
                 protected PasswordAuthentication getPasswordAuthentication(){
                     return new PasswordAuthentication(fromEmail,password);
                 }
             });
             
             Message mess = new MimeMessage(session);
             
             mess.setFrom(new InternetAddress(fromEmail));
             mess.setRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
             mess.setSubject("User Email Vertification");
             mess.setText("Registered successfully.Please verify your account using this code : " + email.getCode());
             
             Transport.send(mess);
             
             test=true;
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        
        return test;
    }
      
      
      
      
}
