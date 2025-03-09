package cn.tuyucheng.taketoday.factorymethod;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/factorymethod/static-bar-config.xml")
public class SingletonBarFactoryIntegrationTest {

   @Autowired
   private Bar instance;

   @Test
   public void givenValidStaticFactoryConfig_whenCreateInstance_thenNameIsCorrect() {
      assertNotNull(instance);
      assertEquals("someName", instance.getName());
   }
}