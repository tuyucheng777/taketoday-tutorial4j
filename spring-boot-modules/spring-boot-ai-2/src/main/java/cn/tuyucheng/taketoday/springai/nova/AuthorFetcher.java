package cn.tuyucheng.taketoday.springai.nova;

import java.util.function.Function;

public class AuthorFetcher implements Function<AuthorFetcher.Query, AuthorFetcher.Author> {

   @Override
   public Author apply(Query author) {
      return new Author("John Doe", "john.doe@taketoday.com");
   }

   public record Author(String name, String emailId) {
   }

   public record Query(String articleTitle) {
   }
}