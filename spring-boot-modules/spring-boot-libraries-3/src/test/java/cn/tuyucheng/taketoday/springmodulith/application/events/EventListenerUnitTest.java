package cn.tuyucheng.taketoday.springmodulith.application.events;

import cn.tuyucheng.taketoday.springmodulith.application.events.orders.OrderCompletedEvent;
import cn.tuyucheng.taketoday.springmodulith.application.events.rewards.LoyalCustomersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EventListenerUnitTest {

   @Autowired
   private LoyalCustomersRepository customers;

   @Autowired
   private ApplicationEventPublisher testEventPublisher;

   @Test
   void whenPublishingOrderCompletedEvent_thenRewardCustomerWithLoyaltyPoints() {
      OrderCompletedEvent event = new OrderCompletedEvent("order-1", "customer-1", Instant.now());

      testEventPublisher.publishEvent(event);

      assertThat(customers.find("customer-1"))
            .isPresent().get()
            .hasFieldOrPropertyWithValue("customerId", "customer-1")
            .hasFieldOrPropertyWithValue("points", 60);
   }
}