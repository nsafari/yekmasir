package ir.yekmasir.config;

import ir.yekmasir.service.imp.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * Created with IntelliJ IDEA.
 * User: Emertat
 * Date: 12/26/14
 * Time: 10:06 AM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/app/controller/**", "/app/directives/**", "/app/model/**", "/app/services/**", "/assets/**", "favicon.ico", "/email");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.userDetailsService(userDetailsService)
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/index.html", "/app/app.js").permitAll()
                .antMatchers("/app/views/search.html").hasRole("USER")
                .antMatchers("/app/views/addlift.html").hasRole("USER")
                .antMatchers("/lift/**").hasRole("USER")
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/user/login")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .permitAll();


    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new LoginService();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new ir.yekmasir.service.imp.AuthenticationFailureHandler();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new ir.yekmasir.service.imp.AuthenticationSuccessHandler();
    }

}
