package cn.tuyucheng.taketoday.spring.data.jpa.listrepositories.lastrecord;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Post {

   @Id
   private Long id;
   private String title;
   private LocalDate publicationDate;

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

   public LocalDate getPublicationDate() {
      return publicationDate;
   }

   public void setPublicationDate(LocalDate publicationDate) {
      this.publicationDate = publicationDate;
   }

}
