package cn.tuyucheng.taketoday.crud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
   @NotBlank(message = "Name is mandatory")
   private String name;

   @NotBlank(message = "Email is mandatory")
   private String email;

   public User() {
   }

   public User(String name, String email) {
      this.name = name;
      this.email = email;
   }

   public void setId(long id) {
      this.id = id;
   }

   public long getId() {
      return id;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getName() {
      return name;
   }

   public String getEmail() {
      return email;
   }

   @Override
   public String toString() {
      return STR."User{id=\{id}, name=\{name}, email=\{email}\{'}'}";
   }
}