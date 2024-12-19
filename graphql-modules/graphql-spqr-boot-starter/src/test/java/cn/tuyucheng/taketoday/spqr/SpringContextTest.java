package cn.tuyucheng.taketoday.spqr;

import cn.tuyucheng.taketoday.SpqrBootStarterApp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpqrBootStarterApp.class)
class SpringContextTest {

   @Test
   void whenSpringContextIsBootstrapped_thenNoExceptions() {
   }
}