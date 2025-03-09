package cn.tuyucheng.taketoday.disableautowiring;

import cn.tuyucheng.taketoday.disableautowiring.thirdpartylib.TestBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

//@SpringBootTest
class DisableAutowireLiveTest {

   @Autowired
   private ApplicationContext applicationContext;

   @Test
   void whenTestBeanIsCraetedWithBeanAnnotation_thenItShouldFail() {
      TestBean testBean = applicationContext.getBean(TestBean.class);
      Assertions.assertNotNull(testBean);
   }
}