package cn.tuyucheng.taketoday.states;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {
   @Id
   private String name;

   @ManyToOne
   private UserEntity manager;

   public UserEntity(String name) {
      this.name = name;
   }
}