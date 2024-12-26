package cn.tuyucheng.taketoday.queryhint;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "app_user")
@NamedQueries({@NamedQuery(name = "selectEmployee", query = "SELECT e FROM Employee e", hints = @QueryHint(name = "org.hibernate.fetchSize", value = "50"))})
public class Employee {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String username;
   private String password;
   private String gender;
   private String name;
   private Date joinDate;
   private int age;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getGender() {
      return gender;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Date getJoinDate() {
      return joinDate;
   }

   public void setJoinDate(Date joinDate) {
      this.joinDate = joinDate;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }
}