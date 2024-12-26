package cn.tuyucheng.taketoday.spring.data.jpa.optionalfields.sqlmapping;

import cn.tuyucheng.taketoday.spring.data.jpa.optionalfields.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookSqlMappingRepository extends JpaRepository<Book, Integer>, BookCustomRepository {
}