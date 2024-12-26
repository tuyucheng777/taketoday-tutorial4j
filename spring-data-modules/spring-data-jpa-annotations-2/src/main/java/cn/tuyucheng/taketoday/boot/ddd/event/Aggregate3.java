package cn.tuyucheng.taketoday.boot.ddd.event;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.data.domain.AbstractAggregateRoot;

@Entity
public class Aggregate3 extends AbstractAggregateRoot<Aggregate3> {
   @Id
   @GeneratedValue
   private long id;

   public void domainOperation() {
      // some domain operation
      registerEvent(new DomainEvent());
   }
}