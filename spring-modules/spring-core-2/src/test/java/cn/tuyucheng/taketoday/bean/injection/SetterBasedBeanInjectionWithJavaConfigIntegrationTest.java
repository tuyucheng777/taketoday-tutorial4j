package cn.tuyucheng.taketoday.bean.injection;

import cn.tuyucheng.taketoday.bean.config.SetterBasedShipConfig;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SetterBasedBeanInjectionWithJavaConfigIntegrationTest {

   private static final String HELM_NAME = "HelmBrand";

   @Test
   public void givenJavaConfigFile_whenUsingSetterBasedBeanInjection_thenCorrectHelmName() {
      AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
      ctx.register(SetterBasedShipConfig.class);
      ctx.refresh();

      Ship ship = ctx.getBean(Ship.class);

      Assert.assertEquals(HELM_NAME, ship.getHelm().getBrandOfHelm());
   }
}