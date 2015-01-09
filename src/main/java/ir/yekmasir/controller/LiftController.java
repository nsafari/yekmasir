package ir.yekmasir.controller;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ir.yekmasir.model.Traffic;
import ir.yekmasir.repository.LeftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: Emertat
 * Date: 1/9/15
 * Time: 10:21 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value="/lift")
public class LiftController {

    @Autowired
    private LeftRepository leftRepository;

    @RequestMapping(value = "/addLift", method = RequestMethod.POST)
    @ResponseBody
    public ObjectNode Add(@RequestBody Traffic traffic) {
        leftRepository.save(traffic);
        return JsonNodeFactory.instance.objectNode().put("result", "succeed");
    }
}
