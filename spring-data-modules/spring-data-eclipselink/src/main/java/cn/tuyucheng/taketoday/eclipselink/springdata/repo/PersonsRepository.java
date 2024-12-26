package cn.tuyucheng.taketoday.eclipselink.springdata.repo;

import cn.tuyucheng.taketoday.eclipselink.springdata.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonsRepository extends CrudRepository<Person, Long> {

   Person findByFirstName(String firstName);
}