package cn.tuyucheng.taketoday.spring.data.couchbase.service;

import cn.tuyucheng.taketoday.spring.data.couchbase.model.Person;
import cn.tuyucheng.taketoday.spring.data.couchbase.repos.PersonRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Qualifier("PersonRepositoryService")
public class PersonRepositoryService implements PersonService {

   private PersonRepository repo;

   @Autowired
   public void setPersonRepository(PersonRepository repo) {
      this.repo = repo;
   }

   public Optional<Person> findOne(String id) {
      return repo.findById(id);
   }

   public List<Person> findAll() {
      List<Person> people = new ArrayList<>();
      for (Person person : repo.findAll()) {
         people.add(person);
      }
      return people;
   }

   public List<Person> findByFirstName(String firstName) {
      return repo.findByFirstName(firstName);
   }

   public List<Person> findByLastName(String lastName) {
      return repo.findByLastName(lastName);
   }

   public void create(Person person) {
      person.setCreated(DateTime.now());
      repo.save(person);
   }

   public void update(Person person) {
      person.setUpdated(DateTime.now());
      repo.save(person);
   }

   public void delete(Person person) {
      repo.delete(person);
   }
}