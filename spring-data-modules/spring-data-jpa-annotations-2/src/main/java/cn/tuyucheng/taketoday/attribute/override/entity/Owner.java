package cn.tuyucheng.taketoday.attribute.override.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Owner {
   private String name;
   private String surname;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getSurname() {
      return surname;
   }

   public void setSurname(String surname) {
      this.surname = surname;
   }
}