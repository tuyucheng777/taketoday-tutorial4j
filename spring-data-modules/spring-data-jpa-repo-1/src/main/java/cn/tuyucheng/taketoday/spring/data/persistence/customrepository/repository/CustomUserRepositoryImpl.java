package cn.tuyucheng.taketoday.spring.data.persistence.customrepository.repository;

import cn.tuyucheng.taketoday.spring.data.persistence.customrepository.model.User;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Objects;

public class CustomUserRepositoryImpl implements CustomUserRepository {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public User customFindMethod(Long id) {
      return (User) entityManager.createQuery("FROM User u WHERE u.id = :id")
            .setParameter("id", id)
            .getSingleResult();
   }

   @PostConstruct
   public void postConstruct() {
      Objects.requireNonNull(entityManager);
   }
}