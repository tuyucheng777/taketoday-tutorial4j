package cn.tuyucheng.taketoday.contexttests.mongoconfig;

import cn.tuyucheng.taketoday.config.MongoConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * This Live test requires:
 * * mongodb instance running on the environment
 * <p>
 * (e.g. `docker run -d -p 27017:27017 --name bael-mongo mongo`)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoConfig.class)
public class SpringContextLiveTest {

   @Test
   public void whenSpringContextIsBootstrapped_thenNoExceptions() {
   }
}