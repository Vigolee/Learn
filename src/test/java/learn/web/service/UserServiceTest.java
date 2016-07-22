package learn.web.service;

import learn.web.config.BasicTest;
import learn.web.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Vigo on 16/7/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:conf/SpringMVC-servlet.xml")
public class UserServiceTest extends BasicTest {

    @Resource
    private UserService userService;

    @Test
    public void addUserTest(){
        User user = new User();
        user.setName("Bunny");
        user.setAge(25);
        user.setAddress("nanping");
        user.setSex("female");
        userService.addUser(user);
    }
}
