package cn.tuyucheng.taketoday.attribute.override.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Vehicle {
   @Id
   @GeneratedValue
   private Integer id;
   private String identifier;
   private Integer numberOfWheels;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getIdentifier() {
      return identifier;
   }

   public void setIdentifier(String identifier) {
      this.identifier = identifier;
   }

   public Integer getNumberOfWheels() {
      return numberOfWheels;
   }

   public void setNumberOfWheels(Integer numberOfWheels) {
      this.numberOfWheels = numberOfWheels;
   }
}