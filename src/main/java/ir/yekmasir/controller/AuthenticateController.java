package ir.yekmasir.controller;

import ir.yekmasir.exception.DuplicateUserEmail;
import ir.yekmasir.exception.EnityNotFoundException;
import ir.yekmasir.exception.UserNotActiveException;
import ir.yekmasir.model.User;
import ir.yekmasir.repository.UserRepository;
import ir.yekmasir.service.SignupConfirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Emertat
 * Date: 11/28/14
 * Time: 3:49 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/user")
public class AuthenticateController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SignupConfirmService signupConfirmService;

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    @ResponseBody
    public String Signup(@RequestBody User user) throws DuplicateUserEmail {
        User theUser = userRepository.findByEmail(user.getEmail());
        if(theUser != null){
            throw new DuplicateUserEmail("This email address is already exists");
        }

        user.setSignupDate(new Date());
        user.setUserEnabled(false);

        signupConfirmService.startConfirm(user);

        userRepository.save(user);
        return "{\"result\": \"email is sent successfully\"}";
    }

    @RequestMapping(value = "/verifyEmail", method = RequestMethod.GET)
    public void VerifyEmail(@RequestParam("code") String code, HttpServletResponse httpServletResponse){
        User user = userRepository.findByEmailConfirmToken(code);
        if(user == null)
            httpServletResponse.setHeader("Location", "http://localhost/");

        signupConfirmService.doConfirm(user);
        userRepository.save(user);
        httpServletResponse.setHeader("Location", "http://localhost/#/login");
    }
}
