package cn.tuyucheng.taketoday.boot.daos.impl;

import cn.tuyucheng.taketoday.boot.domain.Person;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class PersonInsertRepository {

   @PersistenceContext
   private EntityManager entityManager;

   @Transactional
   public void insertWithQuery(Person person) {
      entityManager.createNativeQuery("INSERT INTO person (id, first_name, last_name) VALUES (?,?,?)")
            .setParameter(1, person.getId())
            .setParameter(2, person.getFirstName())
            .setParameter(3, person.getLastName())
            .executeUpdate();
   }

   @Transactional
   public void insertWithEntityManager(Person person) {
      this.entityManager.persist(person);
   }
}