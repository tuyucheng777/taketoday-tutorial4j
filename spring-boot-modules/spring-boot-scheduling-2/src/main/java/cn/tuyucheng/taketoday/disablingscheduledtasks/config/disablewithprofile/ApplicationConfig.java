package cn.tuyucheng.taketoday.disablingscheduledtasks.config.disablewithprofile;

import cn.tuyucheng.taketoday.disablingscheduledtasks.DelayedNotificationScheduler;
import cn.tuyucheng.taketoday.disablingscheduledtasks.NotificationRepository;
import cn.tuyucheng.taketoday.disablingscheduledtasks.NotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class ApplicationConfig {

   @Bean
   public Clock clock() {
      return Clock.systemUTC();
   }

   @Bean
   public NotificationRepository notificationRepository() {
      return new NotificationRepository();
   }

   @Bean
   public NotificationService notificationService(NotificationRepository notificationRepository, Clock clock) {
      return new NotificationService(notificationRepository, clock);
   }

   @Bean
   public DelayedNotificationScheduler delayedNotificationScheduler(NotificationService notificationService) {
      return new DelayedNotificationScheduler(notificationService);
   }
}