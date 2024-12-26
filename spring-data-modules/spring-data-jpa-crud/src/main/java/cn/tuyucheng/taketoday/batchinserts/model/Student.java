package cn.tuyucheng.taketoday.batchinserts.model;

import jakarta.persistence.*;

@Entity
public class Student {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private long id;

   private String name;

   @ManyToOne
   private School school;

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public School getSchool() {
      return school;
   }

   public void setSchool(School school) {
      this.school = school;
   }
}