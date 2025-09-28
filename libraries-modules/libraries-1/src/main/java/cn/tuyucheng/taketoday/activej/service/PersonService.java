package cn.tuyucheng.taketoday.activej.service;

import cn.tuyucheng.taketoday.activej.model.VerifiedPerson;
import cn.tuyucheng.taketoday.activej.repository.PersonRepository;

import io.activej.promise.Promise;

public class PersonService {
   private final PersonRepository personRepository;

   public PersonService(PersonRepository personRepository) {
      this.personRepository = personRepository;
   }

   public PersonRepository getPersonRepository() {
      return personRepository;
   }

   public Promise<VerifiedPerson> findAndVerifyPerson(String name) {
      return personRepository.findPerson(name)
            .combine(findPersonNotes(name),
                  (person, notes) -> new VerifiedPerson(person.name(), person.description(), notes, null))
            .map(this::verify);
   }

   private VerifiedPerson verify(VerifiedPerson person) {
      if (person.description().startsWith("Good")) {
         return new VerifiedPerson(person.name(), person.description(),
               person.notes(), "SUCCESS");
      }

      return new VerifiedPerson(person.name(), person.description(),
            person.notes(), "FAIL");
   }

   private Promise<String> findPersonNotes(String name) {
      return Promise.of(name + " notes");
   }
}