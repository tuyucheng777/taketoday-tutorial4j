package cn.tuyucheng.taketoday.springai.mcp.server;

import org.springframework.ai.tool.annotation.Tool;

import java.util.List;

class AuthorRepository {

   @Tool(description = "Get Tuyucheng author details using an article title")
   Author getAuthorByArticleTitle(String articleTitle) {
      return new Author("John Doe", "john.doe@tuyucheng.com");
   }

   @Tool(description = "Get highest rated Tuyucheng authors")
   List<Author> getTopAuthors() {
      return List.of(
            new Author("John Doe", "john.doe@tuyucheng.com"),
            new Author("Jane Doe", "jane.doe@tuyucheng.com")
      );
   }

   record Author(String name, String email) {
   }
}