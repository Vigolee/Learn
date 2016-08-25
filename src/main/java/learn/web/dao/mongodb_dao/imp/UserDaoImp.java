package learn.web.dao.mongodb_dao.imp;

import com.mongodb.DB;
import learn.web.dao.mongodb_dao.UserDao;
import learn.web.po.mongdb_model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * Created by Vigo on 16/8/23.
 */
@Component("userDaoImp")
public class UserDaoImp implements UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void _test() {
        Set<String> colls = this.mongoTemplate.getCollectionNames();
        for (String coll : colls) {
            System.out.println("CollectionName=" + coll);
        }
        DB db = this.mongoTemplate.getDb();
        System.out.println("db = " + db.toString());
    }

    public void createCollection() {

    }

    public List<User> findList(int skip, int limit) {
        return null;
    }

    public List<User> findListByAge(int age) {
        return null;
    }

    public User findOne(String id) {
        return null;
    }

    public User findOneByUsername(String username) {
        return null;
    }

    public void insert(User entity) {

    }

    public void update(User entity) {

    }
}
