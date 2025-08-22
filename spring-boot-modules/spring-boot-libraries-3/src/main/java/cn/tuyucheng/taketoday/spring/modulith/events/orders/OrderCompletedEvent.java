package cn.tuyucheng.taketoday.spring.modulith.events.orders;

import java.time.Instant;

public record OrderCompletedEvent(String orderId, String customerId, Instant timestamp) {
}