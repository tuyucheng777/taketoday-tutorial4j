package cn.tuyucheng.taketoday;

import cn.tuyucheng.taketoday.boot.Application;
import cn.tuyucheng.taketoday.boot.config.PersistenceConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest(excludeAutoConfiguration = {
      PersistenceConfiguration.class})
@ContextConfiguration(classes = Application.class)
public class SpringJpaContextIntegrationTest {

   @Test
   public void whenSpringContextIsBootstrapped_thenNoExceptions() {
   }
}