package cn.tuyucheng.taketoday.cassecuredapp.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CasUser {
   @Id
   private Long id;

   @Column(nullable = false, unique = true)
   private String email;

   private String password;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }


   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }
}