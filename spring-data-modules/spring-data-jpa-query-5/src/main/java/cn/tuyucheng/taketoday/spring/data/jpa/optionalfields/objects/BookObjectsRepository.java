package cn.tuyucheng.taketoday.spring.data.jpa.optionalfields.objects;

import cn.tuyucheng.taketoday.spring.data.jpa.optionalfields.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookObjectsRepository extends JpaRepository<Book, Integer> {
   @Query("SELECT b.id, b.title, b.author FROM Book b")
   List<Object[]> fetchBooks();
}