package cn.tuyucheng.taketoday.web;

import cn.tuyucheng.taketoday.persistence.service.IFooService;
import cn.tuyucheng.taketoday.web.controller.FooController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * We'll start only the web layer.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(FooController.class)
public class FooControllerWebLayerIntegrationTest {

   @Autowired
   private MockMvc mockMvc;

   @MockBean
   private IFooService service;

   @Test
   public void whenTestMvcController_thenRetrieveExpectedResult() throws Exception {
      this.mockMvc.perform(get("/foos"))
            .andExpect(status().isOk())
            .andExpect(content().json("[]"));
   }
}