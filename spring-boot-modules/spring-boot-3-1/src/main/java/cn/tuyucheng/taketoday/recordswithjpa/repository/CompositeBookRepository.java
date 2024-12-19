package cn.tuyucheng.taketoday.recordswithjpa.repository;

import cn.tuyucheng.taketoday.recordswithjpa.entity.CompositeBook;
import cn.tuyucheng.taketoday.recordswithjpa.records.BookId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompositeBookRepository extends JpaRepository<CompositeBook, BookId> {
}