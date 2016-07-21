package learn.web.controller;

import learn.web.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Vigo on 16/5/26.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource(name = "userService")
    private UserService service;

    @RequestMapping(value = "/instance",
            method = RequestMethod.GET)
    @ResponseBody
    public String call(int id) {
        System.out.println(id + "----");
        return "hello";
    }
}
