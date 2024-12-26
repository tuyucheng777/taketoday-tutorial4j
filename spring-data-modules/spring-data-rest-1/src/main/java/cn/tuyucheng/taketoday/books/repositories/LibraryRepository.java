package cn.tuyucheng.taketoday.books.repositories;

import cn.tuyucheng.taketoday.books.models.Library;
import org.springframework.data.repository.CrudRepository;

public interface LibraryRepository extends CrudRepository<Library, Long> {
}