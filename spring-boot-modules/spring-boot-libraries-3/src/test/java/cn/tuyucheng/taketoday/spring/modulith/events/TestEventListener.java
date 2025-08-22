package cn.tuyucheng.taketoday.spring.modulith.events;

import cn.tuyucheng.taketoday.spring.modulith.events.orders.OrderCompletedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class TestEventListener {

   private final List<OrderCompletedEvent> events = new ArrayList<>();

   @EventListener
   void onEvent(OrderCompletedEvent event) {
      events.add(event);
   }

   public List<OrderCompletedEvent> getEvents() {
      return events;
   }

   public void reset() {
      events.clear();
   }
}