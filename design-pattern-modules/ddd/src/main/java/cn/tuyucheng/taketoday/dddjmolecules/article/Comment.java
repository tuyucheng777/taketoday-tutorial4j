package cn.tuyucheng.taketoday.dddjmolecules.article;

import cn.tuyucheng.taketoday.dddjmolecules.author.Username;
import org.jmolecules.ddd.annotation.Entity;
import org.jmolecules.ddd.annotation.Identity;

import java.time.Instant;
import java.util.UUID;

@Entity
public class Comment {
   @Identity
   private final String id;
   private final Username author;
   private String message;
   private Instant lastModified;

   Comment(Username author, String message) {
      this.id = UUID.randomUUID()
            .toString();
      this.author = author;
      this.message = message;
      this.lastModified = Instant.now();
   }

   public void edit(String newMessage) {
      this.message = newMessage;
      this.lastModified = Instant.now();
   }
}