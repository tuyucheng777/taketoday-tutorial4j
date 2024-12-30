package cn.tuyucheng.taketoday.objecthydration.repository;

import cn.tuyucheng.taketoday.objecthydration.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}