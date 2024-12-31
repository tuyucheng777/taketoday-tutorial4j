package cn.tuyucheng.taketoday.micronaut.environments.services.logging;

import io.micronaut.context.ApplicationContext;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@MicronautTest(environments = {"canary-production"})
public class CanaryProductionEnvironmentLoggingUnitTest {

   @Inject
   LoggingService loggingService;
   @Inject
   ApplicationContext applicationContext;

   @Test
   public void whenEnvironmentIsSetToCanaryProduction_thenActiveEnvironmentsAreTestAndCanaryProduction() {
      assertThat(applicationContext.getEnvironment()
            .getActiveNames()).containsExactlyInAnyOrder("test", "canary-production");
   }

   @Test
   public void givenEnvironmentIsSetToCanaryProduction_whenLog_thenOverridesDefaultAndUsesFileLoggingService() {
      String prodLog = loggingService.log("something");

      assertThat(prodLog).isEqualTo("logging to some file: [something]");
   }
}
