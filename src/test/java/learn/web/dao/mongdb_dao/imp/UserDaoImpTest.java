package learn.web.dao.mongdb_dao.imp;

import learn.web.dao.mongodb_dao.imp.UserDaoImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Vigo on 16/8/23.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/applicationContext.xml",
        "classpath:conf/SpringMVC-servlet.xml"})
public class UserDaoImpTest {

    @Resource
    UserDaoImp userDaoImp;

    @Test
         public void _testTest() {
        userDaoImp._test();
    }
}
