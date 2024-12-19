package cn.tuyucheng.taketoday.startwithoutdb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;

@SpringBootTest(classes = StartWithoutDbApplication.class)
class StartWithoutDbIntegrationTest {

   @Autowired
   private ApplicationContext context;

   @Test
   void givenAutoConfigDisabled_whenStarting_thenNoAutoconfiguredBeansInContext() {
      context.getBean(DataSource.class);
   }
}