package cn.tuyucheng.taketoday.messaging.postgresql.config;

import cn.tuyucheng.taketoday.messaging.postgresql.service.NotificationHandler;
import cn.tuyucheng.taketoday.messaging.postgresql.service.NotifierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ListenerConfiguration {

   @Bean
   CommandLineRunner startListener(NotifierService notifier, NotificationHandler handler) {
      return (_) -> {
         LOGGER.info("Starting order listener thread...");
         Runnable listener = notifier.createNotificationHandler(handler);
         Thread t = new Thread(listener, "order-listener");
         t.start();
      };
   }
}