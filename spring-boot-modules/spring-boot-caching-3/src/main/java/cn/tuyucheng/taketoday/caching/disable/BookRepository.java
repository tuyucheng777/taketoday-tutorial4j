package cn.tuyucheng.taketoday.caching.disable;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookReview, Long> {

   List<BookReview> findByIsbn(String isbn);
}