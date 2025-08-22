package cn.tuyucheng.taketoday.spring.modulith.cqrs.ticket;

import org.jmolecules.architecture.cqrs.Command;

@Command
record CancelTicket(Long bookingId) {
}