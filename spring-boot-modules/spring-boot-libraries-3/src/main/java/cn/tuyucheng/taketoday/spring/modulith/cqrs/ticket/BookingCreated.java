package cn.tuyucheng.taketoday.spring.modulith.cqrs.ticket;

import org.jmolecules.event.annotation.DomainEvent;

@DomainEvent
public record BookingCreated(Long movieId, String seatNumber) {
}