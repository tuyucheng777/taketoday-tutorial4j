package cn.tuyucheng.taketoday.micronaut.environments.services.logging;

import cn.tuyucheng.taketoday.micronaut.environments.ServerApplication;
import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InvalidEnvironmentLoggingUnitTest {

   @Test
   public void whenEnvironmentIsNotSet_thenLoggingServiceImplementationIsTheDefaultOne() {
      ApplicationContext applicationContext = Micronaut.run(ServerApplication.class);
      applicationContext.start();

      LoggingService loggingService = applicationContext.getBean(LoggingService.class);

      assertThat(applicationContext.getEnvironment()
            .getActiveNames()).containsExactly("test");
      assertThat(loggingService).isNotNull();
      assertThat(loggingService).isExactlyInstanceOf(ConsoleLoggingServiceImpl.class);
   }
}
