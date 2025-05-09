package cn.tuyucheng.taketoday.jpa.aggregation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Entity
public class Comment {
   @Id
   private Integer id;
   private Integer year;
   private boolean approved;
   private String content;
   @ManyToOne
   private Post post;

   public Comment() {
   }

   public Comment(int id, int year, boolean approved, String content, Post post) {
      this.id = id;
      this.year = year;
      this.approved = approved;
      this.content = content;
      this.post = post;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public Integer getYear() {
      return year;
   }

   public void setYear(Integer year) {
      this.year = year;
   }

   public boolean isApproved() {
      return approved;
   }

   public void setApproved(boolean approved) {
      this.approved = approved;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public Post getPost() {
      return post;
   }

   public void setPost(Post post) {
      this.post = post;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (!(o instanceof Comment comment)) {
         return false;
      }
      return getId().equals(comment.getId());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getId());
   }
}