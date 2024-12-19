package cn.tuyucheng.taketoday;

import cn.tuyucheng.taketoday.springbootlogging.SpringBootLoggingApplication;
import cn.tuyucheng.taketoday.syslog.SpringBootSyslogApplication;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootSyslogApplication.class)
public class SpringContextTest {

   @Test
   public void whenSpringContextIsBootstrapped_thenNoExceptions() {
   }
}