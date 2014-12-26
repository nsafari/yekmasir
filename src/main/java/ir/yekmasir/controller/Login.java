package ir.yekmasir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: Emertat
 * Date: 12/26/14
 * Time: 10:36 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/login")
public class Login {

    @RequestMapping(method = RequestMethod.GET)
    public String Index() {
        return "app/views/login.html";
    }
}
