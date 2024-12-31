package cn.tuyucheng.taketoday.chaindofilter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static cn.tuyucheng.taketoday.chaindofilter.ChainDoFilterController.RESPONSE_MESSAGE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ChainExampleFilterUnitTest {

   @Autowired
   private MockMvc mockMvc;

   @Test
   void givenHeaderInResponse_whenFilterDoChain_thenAssertHeaderPresent() throws Exception {
      mockMvc.perform(get("/chain/do-filter"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").value(RESPONSE_MESSAGE));
   }
}