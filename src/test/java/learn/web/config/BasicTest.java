package learn.web.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Vigo on 16/7/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:/WEB-INF/applicationContext.xml",
        "file:/WEB-INF/SpringMVC-servlet.xml"})
public class BasicTest extends AbstractJUnit4SpringContextTests {
        @Test
        public void doTest(){
                System.out.println("nihao");
        }
}

