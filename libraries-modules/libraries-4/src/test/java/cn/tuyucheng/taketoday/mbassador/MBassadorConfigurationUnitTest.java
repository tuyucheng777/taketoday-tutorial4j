package cn.tuyucheng.taketoday.mbassador;

import net.engio.mbassy.bus.MBassador;
import net.engio.mbassy.bus.error.IPublicationErrorHandler;
import net.engio.mbassy.bus.error.PublicationError;
import net.engio.mbassy.listener.Handler;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class MBassadorConfigurationUnitTest implements IPublicationErrorHandler {

   private MBassador dispatcher;
   private String messageString;
   private Throwable errorCause;

   private LinkedList<Integer> list = new LinkedList<>();

   @Before
   public void prepareTests() {

      dispatcher = new MBassador<String>(this);
      dispatcher.subscribe(this);
   }

   @Test
   public void whenErrorOccurs_thenErrorHandler() {
      dispatcher.post("Error").now();
      assertNull(messageString);
      assertNotNull(errorCause);
   }

   @Test
   public void whenNoErrorOccurs_thenStringHandler() {
      dispatcher.post("Errol").now();
      assertNull(errorCause);
      assertNotNull(messageString);
   }

   @Test
   public void whenRejectDispatched_thenPriorityHandled() {
      dispatcher.post(new RejectMessage()).now();

      // Items should pop() off in reverse priority order
      assertEquals(1, (int) list.pop());
      assertEquals(3, (int) list.pop());
      assertEquals(5, (int) list.pop());
   }

   @Handler
   public void handleString(String message) {
      if ("Error".equals(message)) {
         throw new Error("BOOM");
      }

      messageString = message;
   }

   @Override
   public void handleError(PublicationError error) {
      errorCause = error.getCause().getCause();
   }

   @Handler(priority = 5)
   public void handleRejectMessage5(RejectMessage rejectMessage) {
      list.push(5);
   }

   @Handler(priority = 3)
   public void handleRejectMessage3(RejectMessage rejectMessage) {
      list.push(3);
   }

   @Handler(priority = 2, rejectSubtypes = true)
   public void handleMessage(Message rejectMessage) {
      list.push(3);
   }

   @Handler(priority = 0)
   public void handleRejectMessage0(RejectMessage rejectMessage) {
      list.push(1);
   }
}