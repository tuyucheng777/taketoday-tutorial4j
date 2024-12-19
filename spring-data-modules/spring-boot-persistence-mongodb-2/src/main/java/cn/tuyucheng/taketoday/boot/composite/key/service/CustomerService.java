package cn.tuyucheng.taketoday.boot.composite.key.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tuyucheng.taketoday.boot.composite.key.dao.TicketRepository;
import cn.tuyucheng.taketoday.boot.composite.key.data.Ticket;
import cn.tuyucheng.taketoday.boot.composite.key.data.TicketId;

@Service
public class CustomerService {
    @Autowired
    private TicketRepository ticketRepository;

    public Optional<Ticket> find(TicketId id) {
        return ticketRepository.findById(id);
    }

    public Ticket insert(Ticket ticket) {
        return ticketRepository.insert(ticket);
    }

    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
}
