package ir.yekmasir.controller;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public String SendEmail() throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("nassersafari@gmail.com", "fORyADHIS"));
        email.setSSLOnConnect(true);
        email.setFrom("user@gmail.com");

        email.setSubject("TestMail");
        email.setMsg("This is a test mail ... :-)");
        email.addTo("nassersafari@gmail.com");
        email.send();
        return "I'm here";
    }

}
