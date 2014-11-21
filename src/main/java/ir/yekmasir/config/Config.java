package ir.yekmasir.config;

import com.mysql.jdbc.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
public class Config {
    @Bean
    public DataSource dataSource() throws SQLException {
        return new SimpleDriverDataSource(new Driver(), "jdbc:mysql://192.168.1.2:3306/carpooling", "root", "1234");
    }
}
