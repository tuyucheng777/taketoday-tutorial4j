package cn.tuyucheng.taketoday.netty.customhandlersandlisteners;

import cn.tuyucheng.taketoday.netty.customhandlersandlisteners.model.Message;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MessageUnitTest {

   @Test
   void whenBroadcastMessage_thenParsedSuccessfully() {
      String input = "Bob;Hello, world; go!";
      Message message = Message.parse(input);

      assertEquals("Bob", message.getUser());
      assertEquals("Hello, world; go!", message.getMessage());
      assertNotNull(message.getTime());
   }

   @Test
   void whenNewMessage_thenExpectedFormat() {
      Message message = new Message("Alice", "Testing");
      Instant time = message.getTime();

      String expected = time + " - Alice: Testing";
      assertEquals(expected, message.toString());
   }
}