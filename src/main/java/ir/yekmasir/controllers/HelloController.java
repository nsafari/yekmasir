package ir.yekmasir.controllers;

import ir.yekmasir.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

    @Autowired
    ir.yekmasir.repositories.UserRepository userRepository;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
        User user = new User();
        user.setName("Ali");
        user.setFamily("Allavi");
        userRepository.save(user);
		return userRepository.findOne(1).getFamily();
	}
}