package cn.tuyucheng.taketoday.spring.data.jpa.optionalfields.sqlmapping;

import cn.tuyucheng.taketoday.spring.data.jpa.optionalfields.BookDto;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BookSqlMappingRepositoryImpl implements BookCustomRepository {
   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public List<BookDto> fetchBooks() {
      return entityManager.createNativeQuery("SELECT b.id, b.title, b.author FROM Book b", "BookMappingResultSet")
            .getResultList();
   }
}