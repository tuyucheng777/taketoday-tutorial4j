package cn.tuyucheng.taketoday.internalaop;

import cn.tuyucheng.taketoday.Application;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = Application.class)
class AddOneAndDoubleComponentUnitTest {

   @Resource
   private AddOneAndDoubleComponent addOneAndDoubleComponent;

   @Resource
   private AddComponent addComponent;

   @Test
   void whenCallingFromExternalClass_thenAopProxyIsUsed() {
      addComponent.resetCache();

      addOneAndDoubleComponent.addOneAndDouble(0);

      assertThat(addComponent.getCounter()).isEqualTo(1);
   }
}