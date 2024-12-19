package cn.tuyucheng.taketoday.boot.properties.multidocument;

import cn.tuyucheng.taketoday.boot.properties.DemoApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {DemoApplication.class}, webEnvironment = WebEnvironment.MOCK)
public class DefaultMultidocumentFilesIntegrationTest {

   @Value("${take.property}")
   private String takeCustomProperty;

   @Value("${take.root-level-property}")
   private String takeRootProperty;

   @Test
   public void givenDefaultProfileActive_whenApplicationStarts_thenDefaultPropertiesUser() {
      assertThat(takeCustomProperty).isEqualTo("defaultValue");
      assertThat(takeRootProperty).isEqualTo("defaultRootLevelValue");
   }
}