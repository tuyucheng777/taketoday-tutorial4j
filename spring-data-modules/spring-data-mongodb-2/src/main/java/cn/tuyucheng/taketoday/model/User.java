package cn.tuyucheng.taketoday.model;

import cn.tuyucheng.taketoday.annotation.CascadeSave;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class User {

   @Id
   private String id;
   private String name;
   private Integer age;

   @DBRef
   @Field("email")
   @CascadeSave
   private EmailAddress emailAddress;

   private Integer yearOfBirth;

   public User() {
   }

   public User(String name, Integer age) {
      this.name = name;
      this.age = age;
   }

   public String getId() {
      return id;
   }

   public void setId(final String id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public Integer getAge() {
      return age;
   }

   public void setAge(final Integer age) {
      this.age = age;
   }

   public EmailAddress getEmailAddress() {
      return emailAddress;
   }

   public void setEmailAddress(final EmailAddress emailAddress) {
      this.emailAddress = emailAddress;
   }

   public Integer getYearOfBirth() {
      return yearOfBirth;
   }

   public void setYearOfBirth(final Integer yearOfBirth) {
      this.yearOfBirth = yearOfBirth;
   }
}