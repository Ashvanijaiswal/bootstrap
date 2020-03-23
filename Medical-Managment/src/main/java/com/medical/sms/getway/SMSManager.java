package com.medical.sms.getway;

import javax.mail.MessagingException;

import org.springframework.stereotype.Service;

import com.medical.shop.management.system.Medical.Managment.Model.User;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
@Service
public class SMSManager{
    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "AC57b816e83698ed941a929d059069705e";
    public static final String AUTH_TOKEN = "28640aec61524764d3654a0923baafb1";
    public  boolean sendSMS(User user) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        try {
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+91"+user.getContact_number()),
                new com.twilio.type.PhoneNumber("+16084245607"),
                 user.getContact_number()+" ye le tera password "+user.getPassword())
           .create();
        System.out.println(message);
        return true;
        }
        catch(Exception ex)
        {
        	System.out.println(ex);
        	return false;
        }
    }
}

