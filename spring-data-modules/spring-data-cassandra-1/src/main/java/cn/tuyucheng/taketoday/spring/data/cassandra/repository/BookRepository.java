package cn.tuyucheng.taketoday.spring.data.cassandra.repository;

import cn.tuyucheng.taketoday.spring.data.cassandra.model.Book;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepository extends CassandraRepository<Book, UUID> {

   Iterable<Book> findByTitleAndPublisher(String title, String publisher);
}