package iwhale.cloud_service;

import iwhale.cloud_service.test.controller.HelloController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CloudServiceApplicationTests {

    //模拟调用Controller的接口发起请求
    private MockMvc mvc;

    @Before
    public void setUp(){
        mvc=MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void contextLoads() throws Exception {
        //perform执行一次请求，accept用于执行接收的数据类型，andExcept用于判断接口返回的期望值
        /*ResultActions re=mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON));
        re.andExpect(status().isOk()).andExpect(content().string(equalTo("hello")));*/
    }

}
