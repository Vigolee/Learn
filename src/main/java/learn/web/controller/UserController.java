package learn.web.controller;

import learn.web.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Vigo on 16/5/26.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    Log log = LogFactory.getLog(UserController.class);

    @Resource(name = "userService")
    private UserService service;

    @RequestMapping(value = "/call",
            method = RequestMethod.GET)
    @ResponseBody
    public String call(int id) {
        System.out.println(id + "----");
        return "hello" + id;
    }

    @RequestMapping(value = "/callModel",
            method = RequestMethod.GET)
    //@ResponseBody
    public String callModel(Map<String, Object> model) {
       // ModelAndView mav = new ModelAndView() ;
       // mav.addObject("a","nihao");
       // mav.setViewName("User");
        model.put("a","nihao");
        if (true){
            log.info("bugai");
            log.error("chucuos");
        }
        return "User";
    }
}
