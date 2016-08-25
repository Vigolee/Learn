package learn.web.dao.mongodb_dao.imp;

import com.mongodb.DB;
import learn.web.dao.mongodb_dao.UserDao;
import learn.web.po.mongdb_model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
        Set<String> collections = this.mongoTemplate.getCollectionNames();
        for (String collection : collections) {
            System.out.println("CollectionName=" + collection);
        }
        DB db = this.mongoTemplate.getDb();
        System.out.println("db = " + db.toString());
    }

    public void createCollection() {
        if (!this.mongoTemplate.collectionExists(User.class)) {
            this.mongoTemplate.createCollection(User.class);
        }
    }

    public List<User> findList(int skip, int limit) {
        return null;
    }

    public List<User> findListByAge(int age) {
        return null;
    }

    public User findOne(String id) {
        Query query = new Query();
        query.addCriteria(new Criteria("_id").is(id));
        return this.mongoTemplate.findOne(query, User.class);
    }

    public User findOneByUsername(String username) {
        return null;
    }

    public void insert(User user) {
        this.mongoTemplate.insert(user);
    }

    public void update(User user) {
        Query query = new Query();
        query.addCriteria(new Criteria("_id").is(user.getId()));
        Update update = new Update();
        update.set("age", user.getAge());
        update.set("password", user.getPassword());
        update.set("regionName", user.getRegionName());
        update.set("special", user.getSpecial());
        update.set("works", user.getWorks());
        update.set("name", user.getName());
        this.mongoTemplate.updateFirst(query, update, User.class);
    }
}
