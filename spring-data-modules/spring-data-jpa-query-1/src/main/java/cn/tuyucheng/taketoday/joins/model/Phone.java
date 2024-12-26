package cn.tuyucheng.taketoday.joins.model;

import jakarta.persistence.*;

@Entity
public class Phone {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   private String number;

   @ManyToOne
   private Employee employee;

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getNumber() {
      return number;
   }

   public void setNumber(String number) {
      this.number = number;
   }

   public Employee getEmployee() {
      return employee;
   }

   public void setEmployee(Employee employee) {
      this.employee = employee;
   }
}