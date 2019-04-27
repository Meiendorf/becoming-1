package com.meiendorf.notificationservice.helper;

import com.meiendorf.notificationservice.configuration.ConfigProperties;
import com.meiendorf.notificationservice.models.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Component
public class EmailHelper {

    @Autowired
    private ConfigProperties config;

    public MimeMessage createMessage(Session session, EmailRequest request) throws MessagingException {

        MimeMessage msg = new MimeMessage(session);

        InternetAddress[] addresses = InternetAddress.parse(request.getTo(), true);

        msg.setRecipients(Message.RecipientType.TO, addresses);
        msg.setSubject(request.getSubject());
        msg.setSentDate(new Date());
        msg.setText(request.getText());
        msg.setHeader("XPriority", "1");

        return msg;
    }

    public Properties createMessageProperties()
    {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", config.getHost());
        prop.put("mail.smtp.port", config.getPort());
        return prop;
    }

    public Session createMessageSession(Properties prop){
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(config.getLogin(), config.getPassword());
            }
        });
        return session;
    }
}
