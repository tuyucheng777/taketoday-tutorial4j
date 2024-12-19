package cn.tuyucheng.taketoday.h2db.notnull;

import cn.tuyucheng.taketoday.h2db.notnull.daos.ItemRepository;
import cn.tuyucheng.taketoday.h2db.notnull.models.Item;
import jakarta.validation.ConstraintViolationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NotNullVsNullableApplication.class)
@ActiveProfiles("not-null-vs-nullable")
public class ItemIntegrationTest {

   @Autowired
   private ItemRepository itemRepository;

   @Test
   public void shouldNotAllowToPersistNullItemsPrice() {
      assertThatThrownBy(() -> itemRepository.save(new Item())).hasRootCauseInstanceOf(ConstraintViolationException.class)
            .hasStackTraceContaining("propertyPath=price")
            .hasStackTraceContaining("null");
   }
}