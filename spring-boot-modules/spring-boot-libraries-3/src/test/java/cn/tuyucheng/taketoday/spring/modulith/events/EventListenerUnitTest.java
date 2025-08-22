package cn.tuyucheng.taketoday.spring.modulith.events;

import cn.tuyucheng.taketoday.spring.modulith.events.orders.OrderCompletedEvent;
import cn.tuyucheng.taketoday.spring.modulith.events.rewards.LoyalCustomersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ActiveProfiles;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles({"modulith", "h2"})
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