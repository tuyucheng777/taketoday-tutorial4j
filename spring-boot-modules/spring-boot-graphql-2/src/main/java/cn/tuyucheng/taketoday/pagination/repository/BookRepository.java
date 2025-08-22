package cn.tuyucheng.taketoday.pagination.repository;

import cn.tuyucheng.taketoday.pagination.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long>, CrudRepository<Book, Long> {
   List<Book> findByIdGreaterThanOrderByIdAsc(Long cursor, org.springframework.data.domain.Pageable pageable);

   List<Book> findAllByOrderByIdAsc(org.springframework.data.domain.Pageable pageable);

   boolean existsByIdGreaterThan(Long id);
}