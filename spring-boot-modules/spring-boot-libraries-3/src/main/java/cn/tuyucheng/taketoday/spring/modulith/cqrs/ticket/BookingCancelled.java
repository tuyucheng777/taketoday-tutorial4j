package cn.tuyucheng.taketoday.spring.modulith.cqrs.ticket;

import org.jmolecules.event.annotation.DomainEvent;

@DomainEvent
public record BookingCancelled(Long movieId, String seatNumber) {
}