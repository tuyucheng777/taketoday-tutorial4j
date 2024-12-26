package cn.tuyucheng.taketoday.partialupdate.model;

import javax.persistence.*;

@Entity
public class ContactPhone {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public long id;
   @Column(nullable = false)
   public long customerId;
   public String phone;

   @Override
   public String toString() {
      return phone;
   }
}