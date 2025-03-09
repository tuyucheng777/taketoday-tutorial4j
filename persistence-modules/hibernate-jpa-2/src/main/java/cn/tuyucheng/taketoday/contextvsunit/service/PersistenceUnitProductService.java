package cn.tuyucheng.taketoday.contextvsunit.service;

import org.springframework.stereotype.Service;

import cn.tuyucheng.taketoday.contextvsunit.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.transaction.Transactional;

@Service
public class PersistenceUnitProductService {

   @PersistenceUnit(name = "cn.tuyucheng.taketoday.contextvsunit.h2_persistence_unit")
   private EntityManagerFactory emf;

   @Transactional
   public void insertProduct(Product product) {
      EntityManager entityManager = emf.createEntityManager();
      entityManager.persist(product);
   }

   public Product find(long id) {
      EntityManager entityManager = emf.createEntityManager();
      return entityManager.find(Product.class, id);
   }
}
