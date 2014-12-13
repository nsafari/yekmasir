package ir.yekmasir.controller.user;

import ir.yekmasir.exception.EnityNotFoundException;
import ir.yekmasir.exception.UserNotActiveException;
import ir.yekmasir.model.User;
import ir.yekmasir.repository.UserRepository;
import ir.yekmasir.service.SignupConfirmService;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Emertat
 * Date: 11/28/14
 * Time: 3:49 PM
 * To change this template use File | Settings | File Templates.
 */

@RestController
@RequestMapping("/user")
public class AuthenticateController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SignupConfirmService signupConfirmService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User Login(@RequestBody User user) throws EnityNotFoundException, UserNotActiveException {
        final User theUser = userRepository.findByEmail(user.getEmail());
        if(theUser == null)
            throw new UsernameNotFoundException(user.getEmail());
        if(!theUser.isEnabled() || !theUser.getConfirmed())
            throw new UserNotActiveException(user.getEmail());
        return theUser;
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String Signup(@RequestBody User user) throws EmailException {
        user.setSignupDate(new Date());
        user.setUserEnabled(false);

        signupConfirmService.startConfirm(user);

        userRepository.save(user);
        return "success";
    }

    @RequestMapping(value = "/verifyEmail", method = RequestMethod.GET)
    public String VerifyEmail(@RequestParam("code") String code){
        User user = userRepository.findByEmailConfirmToken(code);
        if(user == null)
            return "User not found";

        signupConfirmService.doConfirm(user);
        userRepository.save(user);
        return "User enabled";
    }
}
