package cn.tuyucheng.taketoday.spring.data.jpa.jsontypeexception;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String admitYear;

   @Column(columnDefinition = "json")
   private String address;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getAdmitYear() {
      return admitYear;
   }

   public void setAdmitYear(String admitYear) {
      this.admitYear = admitYear;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }
}