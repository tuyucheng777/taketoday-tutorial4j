package cn.tuyucheng.taketoday.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SenderServiceFactoryUnitTest {

   @Test
   void givenEmailSender_whenCreateInstanceUsingFactory_thenReturnResult() {
      SenderServiceFactory<EmailSender> service = new SenderServiceFactory<>(EmailSender::new);

      Sender emailSender = service.createInstance();
      String result = emailSender.send();

      assertEquals("EMAIL", result);
   }

   @Test
   void givenNotificationSender_whenCreateInstanceUsingFactory_thenReturnResult() {
      SenderServiceFactory<NotificationSender<String>> service = new SenderServiceFactory<>(() -> new NotificationSender<>("Hello from Taketoday"));

      NotificationSender<String> notificationSender = service.createInstance();
      String result = notificationSender.send();

      assertEquals("NOTIFICATION", result);
      assertEquals("Hello from Taketoday", notificationSender.getBody());
   }
}
