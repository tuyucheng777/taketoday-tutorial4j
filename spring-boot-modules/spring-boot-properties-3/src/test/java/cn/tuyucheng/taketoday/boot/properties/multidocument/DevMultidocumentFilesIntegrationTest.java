package cn.tuyucheng.taketoday.boot.properties.multidocument;

import cn.tuyucheng.taketoday.boot.properties.DemoApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {DemoApplication.class}, webEnvironment = WebEnvironment.MOCK)
@ActiveProfiles("multidocument-dev")
public class DevMultidocumentFilesIntegrationTest {

   @Value("${take.property}")
   private String takeCustomProperty;

   @Value("${take.root-level-property}")
   private String takeRootProperty;

   @Test
   public void givenDefaultProfileActive_whenApplicationStarts_thenDefaultPropertiesUser() {
      assertThat(takeCustomProperty).isEqualTo("devValue");
      assertThat(takeRootProperty).isEqualTo("defaultRootLevelValue");
   }
}