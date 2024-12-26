package cn.tuyucheng.taketoday.spring.data.jpa.optionalfields.dto;

import cn.tuyucheng.taketoday.spring.data.jpa.optionalfields.Book;
import cn.tuyucheng.taketoday.spring.data.jpa.optionalfields.BookDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDtoRepository extends JpaRepository<Book, Integer> {
   @Query(value = "SELECT new cn.tuyucheng.taketoday.spring.data.jpa.optionalfields.BookDto(b.id, b.title, b.author) FROM Book b")
   List<BookDto> fetchBooks();
}