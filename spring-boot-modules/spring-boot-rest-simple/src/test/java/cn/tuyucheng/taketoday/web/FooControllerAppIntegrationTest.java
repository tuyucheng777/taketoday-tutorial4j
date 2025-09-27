package cn.tuyucheng.taketoday.web;

import cn.tuyucheng.taketoday.persistence.dao.IFooDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * We'll start the whole context, but not the server. We'll mock the REST calls instead.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FooControllerAppIntegrationTest {

   @Autowired
   private MockMvc mockMvc;

   @Autowired
   private IFooDao fooDao;

   @Before
   public void setup() {
      this.fooDao.deleteAll();
   }

   @Test
   public void whenTestApp_thenEmptyResponse() throws Exception {
      this.mockMvc.perform(get("/foos"))
            .andExpect(status().isOk())
            .andExpect(content().json("[]"));
   }
}