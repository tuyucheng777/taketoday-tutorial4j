package cn.tuyucheng.taketoday.springjunitconfiguration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig(SpringJUnitConfigIntegrationTest.Config.class)
public class SpringJUnitConfigIntegrationTest {

   @Autowired
   private ApplicationContext applicationContext;

   @Test
   void givenAppContext_WhenInjected_ThenItShouldNotBeNull() {
      assertNotNull(applicationContext);
   }

   @Configuration
   static class Config {
   }
}