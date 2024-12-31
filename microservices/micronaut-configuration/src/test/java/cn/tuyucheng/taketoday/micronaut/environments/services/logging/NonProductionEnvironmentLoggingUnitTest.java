package cn.tuyucheng.taketoday.micronaut.environments.services.logging;

import io.micronaut.context.ApplicationContext;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@MicronautTest(environments = {"dev"})
public class NonProductionEnvironmentLoggingUnitTest {

   @Inject
   LoggingService loggingService;
   @Inject
   ApplicationContext applicationContext;

   @Test
   public void whenEnvironmentIsSetToDev_thenActiveEnvironmentsAreTestAndDev() {
      assertThat(applicationContext.getEnvironment()
            .getActiveNames()).containsExactlyInAnyOrder("test", "dev");
   }

   @Test
   public void givenEnvironmentIsSetToDev_whenLog_thenUsesDefaultLoggingService() {
      String devLog = loggingService.log("something");

      assertThat(devLog).isEqualTo("logging to console: [something]");
   }
}
