package cn.tuyucheng.taketoday.springmodulith.application.events.orders;

import java.time.Instant;
import java.util.List;

record Order(String id, String customerId, List<String> productIds, Instant timestamp) {

   public Order(String customerId, List<String> productIds) {
      this(null, customerId, productIds, Instant.now());
   }
}