package ir.yekmasir;

import ir.yekmasir.config.Config;
import ir.yekmasir.model.User;
import ir.yekmasir.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created with IntelliJ IDEA.
 * User: Emertat
 * Date: 11/21/14
 * Time: 10:39 AM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("ir.yekmasir.*")
@Import(value = Config.class)
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
    }
}
