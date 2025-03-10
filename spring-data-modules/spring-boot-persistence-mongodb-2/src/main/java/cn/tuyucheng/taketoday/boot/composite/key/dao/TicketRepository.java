package cn.tuyucheng.taketoday.boot.composite.key.dao;

import cn.tuyucheng.taketoday.boot.composite.key.data.Ticket;
import cn.tuyucheng.taketoday.boot.composite.key.data.TicketId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<Ticket, TicketId> {
}