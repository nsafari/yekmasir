package ir.yekmasir.config;

import com.mysql.jdbc.Driver;
import ir.yekmasir.service.SignupConfirmService;
import ir.yekmasir.service.imp.SignupConfirmEmail;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

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
    public Session emailSession(){
        String host = "yekmasir.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "25");

        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("", "");
            }
        });
        return session;
    }

    @Bean
    @Scope(value="request", proxyMode = ScopedProxyMode.INTERFACES)
    public SignupConfirmService signupConfirmService()
    {
        return new SignupConfirmEmail();
    }
}