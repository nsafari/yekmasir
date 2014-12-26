package ir.yekmasir.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Emertat
 * Date: 12/13/14
 * Time: 1:15 AM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/email")
public class SendEmailController {

    @RequestMapping(method = RequestMethod.GET)
    public String SendEmail(){
        sendEmail();
        return "I'm here";
    }

    private void sendEmail(){
        // Recipient's email ID needs to be mentioned.
        String to = "nassersafari@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "info@yekmasir.com";

        // Assuming you are sending email from localhost
        String host = "yekmasir.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "25");

        // Get the default Session object.
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("senderuser", "apass1");
            }
        });

        try{
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Send the actual HTML message, as big as you like
            message.setContent("<h1>This is actual message.</h1>این یک مثال است.",
                    "text/html;charset=utf-8" );

            Transport.send(message);
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
