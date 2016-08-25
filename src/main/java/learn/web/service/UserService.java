package learn.web.service;


import learn.web.dao.mysql_dao.UserDao;
import learn.web.po.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Vigo on 15/9/23.
 */

@Service("userService")
public class UserService{

    @Resource(name = "userDao")
    private UserDao userDao;

    public void addUser(User user){
        System.out.println(user.age);
        userDao.addUser(user);
    }
}
