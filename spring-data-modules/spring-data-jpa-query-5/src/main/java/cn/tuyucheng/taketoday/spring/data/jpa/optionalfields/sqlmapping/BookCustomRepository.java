package cn.tuyucheng.taketoday.spring.data.jpa.optionalfields.sqlmapping;

import cn.tuyucheng.taketoday.spring.data.jpa.optionalfields.BookDto;

import java.util.List;

public interface BookCustomRepository {
   List<BookDto> fetchBooks();
}