package cn.tuyucheng.taketoday.autowiremultipleimplementations;

import cn.tuyucheng.taketoday.autowiremultipleimplementations.candidates.GoodService;
import cn.tuyucheng.taketoday.autowiremultipleimplementations.candidates.GoodServiceA;
import cn.tuyucheng.taketoday.autowiremultipleimplementations.candidates.GoodServiceB;
import cn.tuyucheng.taketoday.autowiremultipleimplementations.candidates.GoodServiceC;
import cn.tuyucheng.taketoday.autowiremultipleimplementations.components.PrimaryAutowire;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

@SpringBootTest(classes = {PrimaryAutowire.class, GoodServiceC.class, GoodServiceB.class, GoodServiceA.class})
@ExtendWith(SpringExtension.class)
public class PrimaryAutowireUnitTest {

   @Autowired
   private ApplicationContext context;

   @Autowired
   private PrimaryAutowire primaryAutowire;

   @Test
   public void whenPrimaryServiceInjected_thenItShouldBeGoodServiceC() {
      GoodService injectedService = context.getBean(GoodService.class);

      assertInstanceOf(GoodServiceC.class, injectedService);

      String expectedMessage = "Hello from C!"; // GoodServiceC returns this message
      String actualMessage = primaryAutowire.hello();

      assertEquals(expectedMessage, actualMessage);
   }
}