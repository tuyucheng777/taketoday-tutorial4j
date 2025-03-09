package cn.tuyucheng.taketoday.autowiremultipleimplementations;

import cn.tuyucheng.taketoday.autowiremultipleimplementations.candidates.GoodService;
import cn.tuyucheng.taketoday.autowiremultipleimplementations.candidates.GoodServiceE;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {GoodServiceE.class})
@TestPropertySource(properties = {"feature.toggle=disabled"})
public class ConditionalDisabledUnitTest {

   @Autowired(required = false)
   private GoodService goodService;

   @Test
   void testServiceWhenFeatureDisabled() {
      assertNull(goodService, "GoodService should not be autowired when feature.toggle is disabled");
   }
}