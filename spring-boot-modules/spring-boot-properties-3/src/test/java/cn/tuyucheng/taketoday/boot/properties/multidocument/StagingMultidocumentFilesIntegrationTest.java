package cn.tuyucheng.taketoday.boot.properties.multidocument;

import cn.tuyucheng.taketoday.boot.properties.DemoApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {DemoApplication.class}, webEnvironment = WebEnvironment.MOCK)
@ActiveProfiles("multidocument-staging")
public class StagingMultidocumentFilesIntegrationTest {

   @Value("${take.property}")
   private String takeCustomProperty;

   @Value("${take.stagingProperty}")
   private String takeStagingProperty;

   @Value("${take.root-level-property}")
   private String takeRootProperty;

   @Test
   public void givenProductionProfileActive_whenApplicationStarts_thenDefaultPropertiesUser() {
      assertThat(takeStagingProperty).isEqualTo("stagingPropertyValue");
      // application.properties is loaded after the application.yml file and overrides the values
      assertThat(takeCustomProperty).isEqualTo("defaultValue");
      assertThat(takeRootProperty).isEqualTo("defaultRootLevelValue");
   }
}