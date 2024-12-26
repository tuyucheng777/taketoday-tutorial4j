package cn.tuyucheng.taketoday.jpa.simple.repository;

import cn.tuyucheng.taketoday.jpa.simple.model.Book;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookListRepository extends ListCrudRepository<Book, Long> {

   List<Book> findBooksByAuthor(String author);
}