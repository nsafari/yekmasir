package ir.yekmasir.config;

import com.mysql.jdbc.Driver;
import ir.yekmasir.service.SignupConfirmService;
import ir.yekmasir.service.imp.SignupConfirmEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
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
    public DataSource dataSource(@Value("${db.host}") String host, @Value("${db.name}") String dbname, @Value("${db.user}") String username, @Value("${db.pass}") String pass) throws SQLException {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource(new Driver(), "jdbc:mysql://" + host + ":3306/" + dbname, username, pass);
        return dataSource;
    }

    @Bean
    public Session emailSession(){
        String host = "yekmasir.com";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "25");

        Session session = Session.getDefaultInstance(props);
        return session;
    }

    @Bean
    @Scope(value="request", proxyMode = ScopedProxyMode.INTERFACES)
    public SignupConfirmService signupConfirmService()
    {
        return new SignupConfirmEmail();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){
        PropertySourcesPlaceholderConfigurer pspc =
                new PropertySourcesPlaceholderConfigurer();
        Resource[] resources = new ClassPathResource[ ]
                {
                  new ClassPathResource( "application.properties" ),
                  new ClassPathResource( "hibernate.properties")
                };
        pspc.setLocations( resources );
        pspc.setIgnoreUnresolvablePlaceholders( true );
        return pspc;
    }
}