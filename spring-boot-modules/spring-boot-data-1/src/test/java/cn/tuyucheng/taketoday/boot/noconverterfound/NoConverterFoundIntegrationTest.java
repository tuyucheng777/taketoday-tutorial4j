package cn.tuyucheng.taketoday.boot.noconverterfound;

import cn.tuyucheng.taketoday.boot.noconverterfound.controller.StudentRestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentRestController.class)
public class NoConverterFoundIntegrationTest {

   @Autowired
   private MockMvc mockMvc;

    // Remove Getters from Student class to successfully run this test case
    // @Test
    // public void whenGettersNotDefined_thenThrowException() throws Exception {
    //    String url = "/api/student/1";
    //
    //    this.mockMvc.perform(get(url))
    //          .andExpect(status().isInternalServerError())
    //          .andExpect(result -> assertThat(result.getResolvedException())
    //                .isInstanceOf(HttpMessageNotWritableException.class))
    //          .andExpect(result -> assertThat(result.getResolvedException().getMessage())
    //                .contains("No converter found for return value of type"));
    // }

   @Test
   public void whenGettersAreDefined_thenReturnObject() throws Exception {

      String url = "/api/student/2";

      this.mockMvc.perform(get(url))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.firstName").value("John"));
   }

   @Test
   public void whenJsonConverterIsFound_thenReturnResponse() throws Exception {
      String url = "/api/student/v2/1";

      this.mockMvc.perform(get(url))
            .andExpect(status().isOk())
            .andExpect(content().json("{'id':1,'firstName':'Kevin','lastName':'Cruyff', 'grade':'AA'}"));
   }

   @Test
   public void whenConverterNotFound_thenThrowException() throws Exception {
      String url = "/api/student/v3/1";

      this.mockMvc.perform(get(url))
            .andExpect(status().isInternalServerError())
            .andExpect(result -> assertThat(result.getResolvedException()).isInstanceOf(HttpMessageNotWritableException.class))
            .andExpect(result -> assertThat(result.getResolvedException()
                  .getMessage()).contains("No converter for [class cn.tuyucheng.taketoday.boot.noconverterfound.model.Student] with preset Content-Type"));
   }
}