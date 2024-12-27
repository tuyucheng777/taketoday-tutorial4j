package cn.tuyucheng.taketoday.automq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class UserOnboardingInitiatedListener {

   private static final Logger log = LoggerFactory.getLogger(UserOnboardingInitiatedListener.class);

   @KafkaListener(topics = "${cn.tuyucheng.taketoday.topic.onboarding-initiated}", groupId = "user-service")
   public void listen(final User user) {
      log.info("Dispatching user account confirmation email to {}", user.email());
   }
}