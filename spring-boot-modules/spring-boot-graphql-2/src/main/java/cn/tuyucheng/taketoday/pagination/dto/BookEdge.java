package cn.tuyucheng.taketoday.pagination.dto;

import cn.tuyucheng.taketoday.pagination.entity.Book;
import lombok.Getter;

@Getter
public class BookEdge {
   private final Book node;
   private final String cursor;

   public BookEdge(Book node, String cursor) {
      this.node = node;
      this.cursor = cursor;
   }
}