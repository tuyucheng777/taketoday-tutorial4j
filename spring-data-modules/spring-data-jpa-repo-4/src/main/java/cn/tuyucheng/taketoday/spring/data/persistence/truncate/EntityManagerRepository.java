package cn.tuyucheng.taketoday.spring.data.persistence.truncate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EntityManagerRepository {

   @PersistenceContext
   private EntityManager entityManager;

   @Transactional
   public void truncateTable(String tableName) {
      String sql = "TRUNCATE TABLE " + tableName;
      Query query = entityManager.createNativeQuery(sql);
      query.executeUpdate();
   }
}
