package cn.tuyucheng.taketoday.jpa.repository;

import cn.tuyucheng.taketoday.jpa.domain.Foo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFooDAO extends JpaRepository<Foo, Long> {

   Foo findByName(String name);

   @Query("SELECT f FROM Foo f WHERE LOWER(f.name) = LOWER(:name)")
   Foo retrieveByName(@Param("name") String name);
}
