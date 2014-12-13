package ir.yekmasir.config;

import com.mysql.jdbc.Driver;
import ir.yekmasir.service.SignupConfirmService;
import ir.yekmasir.service.imp.SignupConfirmEmail;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Emertat
 * Date: 11/21/14
 * Time: 7:01 PM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@Import(MvcConfig.class)
public class Config {
    @Bean(name="DataSource")
    public DataSource dataSource() throws SQLException {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource(new Driver(), "jdbc:mysql://127.0.0.1:3306/carpooling", "root", "ForJavad");
        return dataSource;
    }

    @Bean
    @Scope("prototype")
    public HtmlEmail htmlEmail() throws EmailException {
        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("username", "password"));
        email.setSSLOnConnect(true);
        email.setFrom("info@yekmasir.com");
        return email;
    }

    @Bean
    public SignupConfirmService signupConfirmService()
    {
        return new SignupConfirmEmail();
    }
}
