package cn.tuyucheng.taketoday.jpa.simple.repository;

import cn.tuyucheng.taketoday.jpa.simple.model.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookPagingAndSortingRepository extends PagingAndSortingRepository<Book, Long>, ListCrudRepository<Book, Long> {

   List<Book> findBooksByAuthor(String author, Pageable pageable);
}