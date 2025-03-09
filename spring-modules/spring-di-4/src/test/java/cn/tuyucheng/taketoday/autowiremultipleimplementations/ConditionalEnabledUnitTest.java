package cn.tuyucheng.taketoday.autowiremultipleimplementations;

import cn.tuyucheng.taketoday.autowiremultipleimplementations.candidates.GoodService;
import cn.tuyucheng.taketoday.autowiremultipleimplementations.candidates.GoodServiceE;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {GoodServiceE.class})
@TestPropertySource(properties = {"feature.toggle=enabled"})
public class ConditionalEnabledUnitTest {

   @Autowired
   private GoodService goodService;

   @Test
   void testServiceWhenFeatureEnabled() {
      assertNotNull(goodService, "GoodService should be autowired when feature.toggle is enabled");
      assertInstanceOf(GoodServiceE.class, goodService, "goodService should be an instance of GoodServiceE");
   }
}