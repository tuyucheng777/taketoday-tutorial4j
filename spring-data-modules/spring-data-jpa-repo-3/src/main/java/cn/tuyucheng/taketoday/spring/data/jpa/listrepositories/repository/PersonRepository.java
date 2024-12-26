package cn.tuyucheng.taketoday.spring.data.jpa.listrepositories.repository;

import cn.tuyucheng.taketoday.spring.data.jpa.listrepositories.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
   Person findByFirstName(String firstName);

   List<Person> findByLastName(String lastName);

   Person findOneByFirstName(String firstName);

   List<Person> findOneByLastName(String lastName);
}