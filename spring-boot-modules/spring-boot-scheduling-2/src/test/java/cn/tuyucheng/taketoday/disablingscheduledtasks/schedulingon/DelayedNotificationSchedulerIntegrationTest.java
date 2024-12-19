package cn.tuyucheng.taketoday.disablingscheduledtasks.schedulingon;

import cn.tuyucheng.taketoday.disablingscheduledtasks.DelayedNotificationScheduler;
import cn.tuyucheng.taketoday.disablingscheduledtasks.Notification;
import cn.tuyucheng.taketoday.disablingscheduledtasks.NotificationRepository;
import cn.tuyucheng.taketoday.disablingscheduledtasks.config.schedulingon.ApplicationConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(
      classes = {ApplicationConfig.class, SchedulerTestConfiguration.class},
      properties = {
            "notification.send.out.delay: 10",
            "notification.send.out.initial.delay: 0"
      }
)
public class DelayedNotificationSchedulerIntegrationTest {

   @Autowired
   private Clock testClock;

   @Autowired
   private NotificationRepository repository;

   @Autowired
   private DelayedNotificationScheduler scheduler;

   @Test
   public void whenTimeIsOverNotificationSendOutTime_thenItShouldBeSent() {
      ZonedDateTime fiveMinutesAgo = ZonedDateTime.now(testClock).minusMinutes(5);
      Notification notification = new Notification(fiveMinutesAgo);
      repository.save(notification);

      scheduler.attemptSendingOutDelayedNotifications();

      Notification processedNotification = repository.findById(notification.getId());
      assertTrue(processedNotification.isSentOut());
   }
}

@TestConfiguration
class SchedulerTestConfiguration {

   @Bean
   @Primary
   public Clock testClock() {
      return Clock.fixed(Instant.parse("2024-03-10T10:15:30.00Z"), ZoneId.systemDefault());
   }
}