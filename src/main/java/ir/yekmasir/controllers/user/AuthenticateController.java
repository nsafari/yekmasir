package ir.yekmasir.controllers.user;

import ir.yekmasir.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void Login(User user) {
        String username = user.getUsername();
    }
}
