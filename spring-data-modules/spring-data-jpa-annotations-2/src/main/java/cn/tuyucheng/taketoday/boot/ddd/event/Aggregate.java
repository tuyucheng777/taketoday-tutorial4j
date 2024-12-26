package cn.tuyucheng.taketoday.boot.ddd.event;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import org.springframework.context.ApplicationEventPublisher;

@Entity
class Aggregate {
   @Transient
   private ApplicationEventPublisher eventPublisher;
   @Id
   private long id;

   private Aggregate() {
   }

   Aggregate(long id, ApplicationEventPublisher eventPublisher) {
      this.id = id;
      this.eventPublisher = eventPublisher;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      return "DomainEntity [id=" + id + "]";
   }

   void domainOperation() {
      // some business logic
      if (eventPublisher != null) {
         eventPublisher.publishEvent(new DomainEvent());
      }
   }

   long getId() {
      return id;
   }
}