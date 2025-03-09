package cn.tuyucheng.taketoday.destroyprototypebean.disposablebean;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DisposableBeanExampleUnitTest {

   private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DisposableBeanConfig.class);

   @Test
   public void givenPrototypeBean_whenDestroyBean_thenAssertDestroyed() {
      DisposableBeanExample bean = context.getBean(DisposableBeanExample.class);

      assertFalse(bean.isDestroyed());
      context.getBeanFactory().destroyBean(bean);
      assertTrue(bean.isDestroyed());

      context.close();
   }
}