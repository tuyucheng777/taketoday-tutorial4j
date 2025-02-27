package cn.tuyucheng.taketoday.controller.push;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import cn.tuyucheng.taketoday.spring.configuration.PushConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringJUnitWebConfig(PushConfiguration.class)
public class PushControllerIntegrationTest {
    @Autowired
    private WebApplicationContext webAppContext;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext)
            .build();
    }

    @Test
    public void whenDemoWithPushGETisPerformed_thenRetrievedStatusOk() throws Exception {
        mockMvc.perform(get("/demoWithPush"))
            .andExpect(status().isOk());
    }

    @Test
    public void whenDemoWithoutPushGETisPerformed_thenRetrievedStatusOk() throws Exception {
        mockMvc.perform(get("/demoWithoutPush"))
            .andExpect(status().isOk());
    }
}