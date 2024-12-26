package cn.tuyucheng.taketoday.datajpadelete.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {

   @Id
   @GeneratedValue
   private Long id;
   private String title;

   @ManyToOne
   private Category category;

   public Book() {
   }

   public Book(String title) {
      this.title = title;
   }

   public Book(String title, Category category) {
      this.title = title;
      this.category = category;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public Category getCategory() {
      return category;
   }

   public void setCategory(Category category) {
      this.category = category;
   }
}