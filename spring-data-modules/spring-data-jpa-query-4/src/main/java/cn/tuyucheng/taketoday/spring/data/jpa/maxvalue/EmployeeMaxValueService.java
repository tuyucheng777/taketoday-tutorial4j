package cn.tuyucheng.taketoday.spring.data.jpa.maxvalue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.Optional;

@Service
public class EmployeeMaxValueService {
   private final EntityManager entityManager;

   @Autowired
   public EmployeeMaxValueService(EntityManager entityManager) {
      this.entityManager = entityManager;
   }

   public Optional<Long> findMaxSalaryCriteriaAPI() {
      CriteriaBuilder cb = entityManager.getCriteriaBuilder();
      CriteriaQuery<Long> query = cb.createQuery(Long.class);

      Root<Employee> root = query.from(Employee.class);
      query.select(cb.max(root.get("salary")));

      TypedQuery<Long> typedQuery = entityManager.createQuery(query);
      return Optional.ofNullable(typedQuery.getSingleResult());
   }
}