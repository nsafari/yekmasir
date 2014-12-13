package ir.yekmasir.service.imp;

import ir.yekmasir.model.User;
import ir.yekmasir.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

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
        User user = userRepository.findByEmail(userName);
        return user;
    }
}
