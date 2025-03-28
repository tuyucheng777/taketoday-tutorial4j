package cn.tuyucheng.taketoday.springdatawebsupport.application.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
   private final String name;

   public User() {
      this.name = "";
   }

   public User(String name) {
      this.name = name;
   }

   public long getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   @Override
   public String toString() {
      return "User{" + "id=" + id + ", name=" + name + '}';
   }
}