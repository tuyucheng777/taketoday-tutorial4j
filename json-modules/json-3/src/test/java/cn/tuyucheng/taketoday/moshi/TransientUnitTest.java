package cn.tuyucheng.taketoday.moshi;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TransientUnitTest {

   @Test
   public void whenSerializing_thenTransientFieldIgnored() {
      Moshi moshi = new Moshi.Builder()
            .build();
      JsonAdapter<Post> jsonAdapter = moshi.adapter(Post.class);

      Post post = new Post("My Post", "Taketoday");
      String json = jsonAdapter.toJson(post);
      System.out.println(json);
   }

   @Test
   public void whenDeserializing_thenTransientFieldIgnored() throws IOException {
      Moshi moshi = new Moshi.Builder()
            .build();
      JsonAdapter<Post> jsonAdapter = moshi.adapter(Post.class);

      String json = "{\"authored_by\":\"Taketoday\",\"title\":\"My Post\"}";
      Post post = jsonAdapter.fromJson(json);
      System.out.println(post);
   }

   public static class Post {
      private String title;
      private transient String author;

      public Post() {
      }

      public Post(String title, String author) {
         this.title = title;
         this.author = author;
      }

      public String getTitle() {
         return title;
      }

      public void setTitle(String title) {
         this.title = title;
      }

      public String getAuthor() {
         return author;
      }

      public void setAuthor(String author) {
         this.author = author;
      }

      @Override
      public String toString() {
         return new ToStringBuilder(this).append("title", title).append("author", author).toString();
      }
   }
}
