package cn.tuyucheng.taketoday.batchinserts;

import cn.tuyucheng.taketoday.batchinserts.model.School;
import cn.tuyucheng.taketoday.boot.Application;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import static cn.tuyucheng.taketoday.batchinserts.TestObjectHelper.createSchool;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
@ActiveProfiles("batchinserts")
@TestPropertySource(properties = "spring.jpa.properties.hibernate.jdbc.batch_size=-1")
public class JpaNoBatchInsertsIntegrationTest {

   @PersistenceContext
   private EntityManager entityManager;

   @Test
   public void whenNotConfigured_ThenSendsInsertsSeparately() {
      for (int i = 0; i < 10; i++) {
         School school = createSchool(i);
         entityManager.persist(school);
      }
   }

   @After
   public void tearDown() {
      entityManager.flush();
   }
}