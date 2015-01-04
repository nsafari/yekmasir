package ir.yekmasir.controller;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: Emertat
 * Date: 1/4/15
 * Time: 7:39 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/index")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String Index() {
        return "index2.html";
    }
}
