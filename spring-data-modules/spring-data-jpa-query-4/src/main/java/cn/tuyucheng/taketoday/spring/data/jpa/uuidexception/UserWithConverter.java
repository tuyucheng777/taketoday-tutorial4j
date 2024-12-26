package cn.tuyucheng.taketoday.spring.data.jpa.uuidexception;

import org.springframework.data.domain.Persistable;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class UserWithConverter implements Persistable<Long> {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Convert(converter = UUIDConverter.class)
   @Column(columnDefinition = "varchar")
   private UUID uuid;

   private String name;

   @Override
   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public UUID getUuid() {
      return uuid;
   }

   public void setUuid(UUID uuid) {
      this.uuid = uuid;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @Override
   public boolean isNew() {
      return true;
   }
}