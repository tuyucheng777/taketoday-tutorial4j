package cn.tuyucheng.taketoday.messaging.postgresql.service;

import cn.tuyucheng.taketoday.messaging.postgresql.domain.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.postgresql.PGNotification;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Consumer;

@Component
@Slf4j
@RequiredArgsConstructor
public class NotificationHandler implements Consumer<PGNotification> {

   private final OrdersService orders;

   @Override
   public void accept(PGNotification t) {
      LOGGER.info("Notification received: pid={}, name={}, param={}", t.getPID(), t.getName(), t.getParameter());
      Optional<Order> order = orders.findById(Long.valueOf(t.getParameter()));
      order.ifPresent(value -> LOGGER.info("order details: {}", value));
   }
}