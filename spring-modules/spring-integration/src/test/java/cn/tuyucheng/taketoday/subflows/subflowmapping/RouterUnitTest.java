package cn.tuyucheng.taketoday.subflows.subflowmapping;

import cn.tuyucheng.taketoday.subflows.subflowmapping.RouterExample.NumbersClassifier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RouterExample.class})
public class RouterUnitTest {
   @Autowired
   private QueueChannel multipleofThreeChannel;

   @Autowired
   private QueueChannel remainderIsOneChannel;

   @Autowired
   private QueueChannel remainderIsTwoChannel;

   @Autowired
   private NumbersClassifier numbersClassifier;

   @Test
   public void whenSendMessagesToFlow_thenNumbersAreClassified() {
      numbersClassifier.classify(Arrays.asList(1, 2, 3, 4, 5, 6));

      Message<?> outMessage = multipleofThreeChannel.receive(0);

      assertEquals(3, outMessage.getPayload());

      outMessage = multipleofThreeChannel.receive(0);

      assertEquals(6, outMessage.getPayload());

      outMessage = remainderIsOneChannel.receive(0);

      assertEquals(1, outMessage.getPayload());
      outMessage = remainderIsOneChannel.receive(0);

      assertEquals(4, outMessage.getPayload());

      outMessage = remainderIsTwoChannel.receive(0);

      assertEquals(2, outMessage.getPayload());

      outMessage = remainderIsTwoChannel.receive(0);

      assertEquals(5, outMessage.getPayload());
   }
}