package cn.tuyucheng.taketoday.spring.data.jpa.maxvalue;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Employee {
   @Id
   @GeneratedValue
   private Integer id;
   private String name;
   private Long salary;

   public Employee() {
   }

   public Employee(Integer id, String name, Long salary) {
      this.id = id;
      this.name = name;
      this.salary = salary;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Long getSalary() {
      return salary;
   }

   public void setSalary(Long salary) {
      this.salary = salary;
   }
}