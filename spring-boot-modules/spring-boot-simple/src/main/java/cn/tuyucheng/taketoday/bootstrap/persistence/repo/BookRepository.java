package cn.tuyucheng.taketoday.bootstrap.persistence.repo;

import cn.tuyucheng.taketoday.bootstrap.persistence.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
   List<Book> findByTitle(String title);
}
