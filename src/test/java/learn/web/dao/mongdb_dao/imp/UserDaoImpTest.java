//package learn.web.dao.mongdb_dao.imp;
//
//import learn.web.config.BasicTest;
//import learn.web.dao.mongodb_dao.imp.UserDaoImp;
//import learn.web.po.mongdb_model.User;
//import org.junit.Test;
//
//import javax.annotation.Resource;
//import java.util.Date;
//
///**
// * Created by Vigo on 16/8/23.
// */
//
//
//public class UserDaoImpTest extends BasicTest{
//
//    @Resource
//    UserDaoImp userDaoImp;
//
//    @Test
//    public void _testTest() {
//        userDaoImp._test();
//    }
//
//    @Test
//    public void insertTest(){
//        User user = new User();
//        user.setId("5");
//        user.setAge(1);
//        user.setBirth(new Date());
//        user.setPassword("123456");
//        user.setRegionName("北京");
//        user.setWorks(1);
//        userDaoImp.insert(user);
//    }
//
//    @Test
//    public void findOneTest(){
//        User user = userDaoImp.findOne("5");
//        System.out.println(user);
//    }
//
//    @Test
//    public void updateTest(){
//        User user = new User();
//        user.setId("5");
//        user.setAge(1);
//        user.setBirth(new Date());
//        user.setPassword("12123213");
//        user.setRegionName("New York");
//        user.setWorks(1);
//        userDaoImp.update(user);
//    }
//}
