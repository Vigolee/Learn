package learn.web.dao.mongodb_dao;

import learn.web.po.mongdb_model.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Vigo on 16/8/23.
 */
@Component("mongodb_userDao")
public interface UserDao {
    public  void _test();

    public  void createCollection();

    public  List<User> findList(int skip, int limit);

    public  List<User> findListByAge(int age);

    public  User findOne(String id);

    public  User findOneByUsername(String username);

    public  void insert(User entity);

    public  void update(User entity);
}
