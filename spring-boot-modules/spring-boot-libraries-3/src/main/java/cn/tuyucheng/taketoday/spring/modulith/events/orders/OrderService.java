package cn.tuyucheng.taketoday.spring.modulith.events.orders;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class OrderService {

   private final OrderRepository repository;
   private final ApplicationEventPublisher eventPublisher;

   public OrderService(OrderRepository orders, ApplicationEventPublisher eventsPublisher) {
      this.repository = orders;
      this.eventPublisher = eventsPublisher;
   }

   public void placeOrder(String customerId, String... productIds) {
      Order order = new Order(customerId, Arrays.asList(productIds));
      // business logic to validate and place the order

      Order savedOrder = repository.save(order);

      OrderCompletedEvent event = new OrderCompletedEvent(savedOrder.id(), savedOrder.customerId(), savedOrder.timestamp());
      eventPublisher.publishEvent(event);
   }
}