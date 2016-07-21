package learn.web.service;


import learn.web.dao.UserDao;
import learn.web.po.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Vigo on 15/9/23.
 */

@Service("userService")
public class UserService{

    private UserDao userDao;

    @Resource(name = "userDao")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(User user){
        System.out.println(user.age);
        userDao.addUser(user);
    }
}
