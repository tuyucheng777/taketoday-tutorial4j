package cn.tuyucheng.taketoday.fallback;

import cn.tuyucheng.taketoday.fallback.messaging.DevelopmentMessagingService;
import cn.tuyucheng.taketoday.fallback.messaging.FallbackMessagingService;
import cn.tuyucheng.taketoday.fallback.messaging.MessagingService;
import cn.tuyucheng.taketoday.fallback.messaging.ProductionMessagingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {FallbackMessagingService.class, DevelopmentMessagingService.class, ProductionMessagingService.class})
public class DevelopmentMessagingServiceUnitTest {

   @Autowired
   private MessagingService messagingService;

   @Test
   public void givenNoProfile_whenSendMessage_thenDevelopmentMessagingService() {
      assertEquals(messagingService.getClass(), DevelopmentMessagingService.class);
   }
}