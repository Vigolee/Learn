package learn.web.controller;

import learn.web.config.BasicTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by Vigo on 16/7/22.
 */
public class UserControllerTest extends BasicTest{

    private MockMvc mockMvc;

    @Before
    public void init(){
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void callTest() {
        try {
            ResultActions resultActions = this.mockMvc.perform(
                    MockMvcRequestBuilders.get("/user/call").param("id", "1"));
            MvcResult result = resultActions.andReturn();
            String content = result.getResponse().getContentAsString();
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
