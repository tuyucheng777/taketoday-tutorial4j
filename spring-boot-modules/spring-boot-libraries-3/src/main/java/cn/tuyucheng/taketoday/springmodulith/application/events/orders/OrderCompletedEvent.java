package cn.tuyucheng.taketoday.springmodulith.application.events.orders;

import java.time.Instant;

public record OrderCompletedEvent(String orderId, String customerId, Instant timestamp) {
}