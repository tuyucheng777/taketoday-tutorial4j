package cn.tuyucheng.taketoday.spring.data.jpa.optionalfields.objects;

import cn.tuyucheng.taketoday.spring.data.jpa.optionalfields.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Tuple;
import java.util.List;

@Repository
public interface BookTupleRepository extends JpaRepository<Book, Integer> {
   @Query(value = "SELECT b.id, b.title, b.author FROM Book b", nativeQuery = true)
   List<Tuple> fetchBooks();
}