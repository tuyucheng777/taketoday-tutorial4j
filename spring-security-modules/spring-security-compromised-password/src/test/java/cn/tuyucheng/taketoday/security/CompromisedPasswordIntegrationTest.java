package cn.tuyucheng.taketoday.security;

import cn.tuyucheng.taketoday.security.dto.UserCreationRequestDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.SneakyThrows;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = Application.class)
@Import(TestSecurityConfiguration.class)
class CompromisedPasswordIntegrationTest {

   @Autowired
   private MockMvc mockMvc;

   @Autowired
   private Validator validator;

   @Test
   @SneakyThrows
   void whenPasswordCompromised_thenExceptionThrown() {
      String emailId = RandomString.make() + "@taketoday.it";
      String password = PasswordCheckerSimulator.FAILURE_KEYWORD + RandomString.make();
      String requestBody = String.format("""
            {
                "emailId"  : "%s",
                "password" : "%s"
            }
            """, emailId, password);

      String apiPath = "/users";
      mockMvc.perform(post(apiPath).contentType(MediaType.APPLICATION_JSON).content(requestBody))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.status").value(HttpStatus.BAD_REQUEST.value()))
            .andExpect(jsonPath("$.detail").value("The provided password is compromised and cannot be used."));
   }

   @Test
   @SneakyThrows
   void whenPasswordNotCompromised_thenUserIsCreated() {
      String emailId = RandomString.make() + "@taketoday.it";
      String password = RandomString.make();
      String requestBody = String.format("""
            {
                "emailId"  : "%s",
                "password" : "%s"
            }
            """, emailId, password);

      String apiPath = "/users";
      mockMvc.perform(post(apiPath).contentType(MediaType.APPLICATION_JSON).content(requestBody))
            .andExpect(status().isOk());
   }

   @Test
   void whenPasswordCompromised_thenValidationFails() {
      UserCreationRequestDto request = new UserCreationRequestDto();
      request.setEmailId(RandomString.make() + "@taketoday.it");
      request.setPassword(PasswordCheckerSimulator.FAILURE_KEYWORD + RandomString.make());

      Set<ConstraintViolation<UserCreationRequestDto>> violations = validator.validate(request);

      assertThat(violations).isNotEmpty();
      assertThat(violations).extracting(ConstraintViolation::getMessage)
            .contains("The provided password is compromised and cannot be used.");
   }
}