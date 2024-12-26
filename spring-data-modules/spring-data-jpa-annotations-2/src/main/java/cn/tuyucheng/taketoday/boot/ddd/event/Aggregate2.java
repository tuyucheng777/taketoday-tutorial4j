package cn.tuyucheng.taketoday.boot.ddd.event;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Aggregate2 {
   @Transient
   private final Collection<DomainEvent> domainEvents;
   @Id
   @GeneratedValue
   private long id;

   public Aggregate2() {
      domainEvents = new ArrayList<>();
   }

   @AfterDomainEventPublication
   public void clearEvents() {
      domainEvents.clear();
   }

   public void domainOperation() {
      // some domain operation
      domainEvents.add(new DomainEvent());
   }

   @DomainEvents
   public Collection<DomainEvent> events() {
      return domainEvents;
   }
}