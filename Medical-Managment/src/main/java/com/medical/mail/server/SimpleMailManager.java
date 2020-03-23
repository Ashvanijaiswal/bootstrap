package com.medical.mail.server;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.medical.shop.management.system.Medical.Managment.Model.User;
@Service
public class SimpleMailManager  {
	
	public final boolean sendMessage(User user) {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(465);

        mailSender.setUsername("ashvanijaiswal7897@gmail.com");
        mailSender.setPassword("@9307638130");
        Properties mailProp = mailSender.getJavaMailProperties();
        mailProp.put("mail.transport.protocol", "smtp");
        mailProp.put("mail.smtp.auth", "true");
        mailProp.put("mail.smtp.starttls.enable", "true");
        mailProp.put("mail.smtp.starttls.required", "true");
        mailProp.put("mail.debug", "true");
        mailProp.put("mail.smtp.ssl.enable", "true");

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(user.getEmail_id());
            helper.setSubject("password yad kr le bc and do not reply");
            helper.setText(
    	            "Dear " + user.getEmail_id()+" your password is "
    		                + user.getPassword()
    		                + ", thank you for Login your account."
    		                );
            mailSender.send(mimeMessage); 
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return false;
    }
	    }

