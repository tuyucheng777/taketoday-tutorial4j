package cn.tuyucheng.taketoday;

import cn.tuyucheng.taketoday.spring.cloud.LogSinkApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = LogSinkApplication.class)
class SpringContextTest {

   @Test
   void contextLoads() {
   }
}