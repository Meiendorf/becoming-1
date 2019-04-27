package com.meiendorf.notificationservice.services;

import com.meiendorf.notificationservice.helper.EmailHelper;
import com.meiendorf.notificationservice.models.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService {

    @Autowired
    private EmailHelper helper;

    public void sendEmail(EmailRequest request) throws MessagingException {
        Properties prop = helper.createMessageProperties();
        Session session = helper.createMessageSession(prop);
        MimeMessage msg = helper.createMessage(session, request);
        Transport.send(msg);
    }

}
