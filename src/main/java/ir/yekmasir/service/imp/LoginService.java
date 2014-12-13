package ir.yekmasir.service.imp;

import ir.yekmasir.model.User;
import ir.yekmasir.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Emertat
 * Date: 11/29/14
 * Time: 7:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class LoginService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(userName);
        return user;
    }
}
