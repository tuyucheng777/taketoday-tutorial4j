package cn.tuyucheng.taketoday.entitygraph;

import cn.tuyucheng.taketoday.entitygraph.model.Characteristic;
import cn.tuyucheng.taketoday.entitygraph.model.Item;
import cn.tuyucheng.taketoday.entitygraph.repository.CharacteristicsRepository;
import cn.tuyucheng.taketoday.entitygraph.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(showSql = false)
@RunWith(SpringRunner.class)
@Sql(scripts = "/entitygraph-data.sql")
public class EntityGraphIntegrationTest {

   @Autowired
   private ItemRepository itemRepo;

   @Autowired
   private CharacteristicsRepository characteristicsRepo;

   @Test
   public void givenEntityGraph_whenCalled_shouldRetrunDefinedFields() {
      Item item = itemRepo.findByName("Table");
      assertThat(item.getId()).isEqualTo(1L);
   }

   @Test
   public void givenAdhocEntityGraph_whenCalled_shouldRetrunDefinedFields() {
      Characteristic characteristic = characteristicsRepo.findByType("Rigid");
      assertThat(characteristic.getId()).isEqualTo(1L);
   }
}