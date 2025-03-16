package cn.tuyucheng.taketoday.spring.oracle.pooling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.tuyucheng.taketoday.spring.oracle.pooling.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
