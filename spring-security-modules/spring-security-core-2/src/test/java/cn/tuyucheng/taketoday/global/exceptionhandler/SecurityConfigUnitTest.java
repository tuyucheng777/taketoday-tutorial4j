package cn.tuyucheng.taketoday.global.exceptionhandler;

import cn.tuyucheng.taketoday.global.exceptionhandler.controller.LoginController;
import cn.tuyucheng.taketoday.global.exceptionhandler.handler.RestError;
import cn.tuyucheng.taketoday.global.exceptionhandler.security.CustomAuthenticationEntryPoint;
import cn.tuyucheng.taketoday.global.exceptionhandler.security.CustomSecurityConfig;
import cn.tuyucheng.taketoday.global.exceptionhandler.security.DelegatedAuthenticationEntryPoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomSecurityConfig.class)
@Import({LoginController.class, CustomAuthenticationEntryPoint.class, DelegatedAuthenticationEntryPoint.class})
public class SecurityConfigUnitTest {

   @Autowired
   private MockMvc mvc;

   @Test
   @WithMockUser(username = "admin", roles = {"ADMIN"})
   public void whenUserAccessLogin_shouldSucceed() throws Exception {
      mvc.perform(formLogin("/login").user("username", "admin")
                  .password("password", "password")
                  .acceptMediaType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
   }

   @Test
   public void whenUserAccessWithWrongCredentialsWithDelegatedEntryPoint_shouldFail() throws Exception {
      RestError re = new RestError(HttpStatus.UNAUTHORIZED.toString(), "Authentication failed");
      mvc.perform(formLogin("/login").user("username", "admin")
                  .password("password", "wrong")
                  .acceptMediaType(MediaType.APPLICATION_JSON))
            .andExpect(status().isUnauthorized())
            .andExpect(jsonPath("$.errorMessage", is(re.getErrorMessage())));
   }
}