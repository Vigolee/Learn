package learn.web.service;

import learn.web.po.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Vigo on 16/7/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/conf/applicationContext.xml",
        "classpath:/conf/SpringMVC-servlet.xml"})
public class UserServiceTest extends AbstractJUnit4SpringContextTests {

    @Resource
    private UserService userService;

    @Test
    public void addUserTest(){
        User user = new User();
        user.setName("Bunny");
        user.setAge(29);
        user.setAddress("nanping");
        user.setSex("female");
        userService.addUser(user);
    }
}
