package cn.tuyucheng.taketoday.spring.data.persistence.unidirectionalcascadingdelete;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Comment {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;

   private String description;
   private Date date;

   public void setId(long id) {
      this.id = id;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public void setDate(Date total) {
      this.date = total;
   }

   public long getId() {
      return id;
   }

   public String getDescription() {
      return description;
   }

   public Date getDate() {
      return date;
   }
}