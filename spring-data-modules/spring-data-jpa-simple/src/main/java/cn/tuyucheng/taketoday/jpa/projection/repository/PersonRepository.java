package cn.tuyucheng.taketoday.jpa.projection.repository;

import cn.tuyucheng.taketoday.jpa.projection.model.Person;
import cn.tuyucheng.taketoday.jpa.projection.view.PersonDto;
import cn.tuyucheng.taketoday.jpa.projection.view.PersonView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends Repository<Person, Long> {
   PersonView findByLastName(String lastName);

   PersonDto findByFirstName(String firstName);

   <T> T findByLastName(String lastName, Class<T> type);

   @Query(name = "person_native_query_dto", nativeQuery = true)
   List<PersonDto> findByFirstNameLike(@Param("firstNameLike") String firstNameLike);
}