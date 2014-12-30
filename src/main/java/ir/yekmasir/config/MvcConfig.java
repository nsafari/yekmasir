package ir.yekmasir.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * Created with IntelliJ IDEA.
 * User: Emertat
 * Date: 11/28/14
 * Time: 4:30 PM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@Import(WebSecurityConfig.class)
public class MvcConfig extends WebMvcConfigurerAdapter{

//    @Bean
//    public InternalResourceViewResolver viewResolver() {
//        InternalResourceViewResolver  viewResolver = new InternalResourceViewResolver();
//        viewResolver.setViewClass(InternalResourceView.class);
//        viewResolver.setPrefix("/");
//        viewResolver.setSuffix(".html");
//        return viewResolver;
//    }

}
