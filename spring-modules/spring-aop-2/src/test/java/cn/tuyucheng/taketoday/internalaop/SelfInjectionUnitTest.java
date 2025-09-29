package cn.tuyucheng.taketoday.internalaop;

import cn.tuyucheng.taketoday.Application;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = Application.class)
class SelfInjectionUnitTest {

   @Resource
   private SelfInjection selfInjection;

   @Test
   void whenCallingFromExternalClass_thenAopProxyIsUsed() {
      selfInjection.resetCache();

      selfInjection.addOneAndDouble(0);

      assertThat(selfInjection.getCounter()).isEqualTo(1);
   }
}