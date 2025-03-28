package cn.tuyucheng.taketoday.methodsecurity;

import cn.tuyucheng.taketoday.methodsecurity.service.UserRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration
@WithMockUser(username = "john", roles = {"VIEWER"})
public class MockUserAtClassLevelIntegrationTest {

   @Test
   public void givenRoleViewer_whenCallGetUsername_thenReturnUsername() {
      String currentUserName = userService.getUsername();
      assertEquals("john", currentUserName);
   }

   @Autowired
   UserRoleService userService;

   @Configuration
   @ComponentScan("cn.tuyucheng.taketoday.methodsecurity.*")
   public static class SpringConfig {
   }
}