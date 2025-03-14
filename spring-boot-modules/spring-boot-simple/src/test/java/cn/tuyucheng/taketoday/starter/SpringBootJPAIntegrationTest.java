package cn.tuyucheng.taketoday.starter;

import cn.tuyucheng.taketoday.starter.domain.GenericEntity;
import cn.tuyucheng.taketoday.starter.repository.GenericEntityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SpringBootJPAIntegrationTest {
   @Autowired
   private GenericEntityRepository genericEntityRepository;

   @Test
   public void givenGenericEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
      GenericEntity genericEntity = genericEntityRepository.save(new GenericEntity("test"));
      GenericEntity foundEntity = genericEntityRepository.findById(genericEntity.getId()).orElse(null);
      assertNotNull(foundEntity);
      assertEquals(genericEntity.getValue(), foundEntity.getValue());
   }
}
