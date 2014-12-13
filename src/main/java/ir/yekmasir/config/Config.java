package ir.yekmasir.config;

import com.mysql.jdbc.Driver;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
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
}
