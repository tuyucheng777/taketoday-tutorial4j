package cn.tuyucheng.taketoday.destroyprototypebean.beanpostprocessor;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomPostProcessorUnitTest {

   private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanPostProcessorConfig.class);

   @Test
   public void givenPrototypeBean_whenDestroyBean_thenAssertDestroyed() {
      PostProcessorBeanExample bean = context.getBean(PostProcessorBeanExample.class);

      assertFalse(bean.isDestroyed());
      context.getBeanFactory().destroyBean(bean);
      assertTrue(bean.isDestroyed());

      context.close();
   }
}