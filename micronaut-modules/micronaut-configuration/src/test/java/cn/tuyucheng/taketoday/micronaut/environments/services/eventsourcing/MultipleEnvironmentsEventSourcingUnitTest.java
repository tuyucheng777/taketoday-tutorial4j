package cn.tuyucheng.taketoday.micronaut.environments.services.eventsourcing;

import io.micronaut.context.ApplicationContext;
import io.micronaut.context.exceptions.NonUniqueBeanException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MultipleEnvironmentsEventSourcingUnitTest {

   @Test
   public void whenEnvironmentIsSetToBothProductionAndDev_thenEventSourcingServiceBeanHasConflict() {
      ApplicationContext applicationContext = ApplicationContext.builder("dev", "production")
            .build();
      applicationContext.start();

      assertThat(applicationContext.getEnvironment()
            .getActiveNames()).containsExactly("test", "dev", "production");
      assertThatThrownBy(() -> applicationContext.getBean(EventSourcingService.class)).isInstanceOf(NonUniqueBeanException.class)
            .hasMessageStartingWith("Multiple possible bean candidates found: [");
   }

   @Test
   public void whenEnvironmentIsSetToBothProductionAndDev_thenTestPropertyGetsValueBasedOnPriority() {
      ApplicationContext applicationContext = ApplicationContext.builder("dev", "production")
            .build();
      applicationContext.start();

      assertThat(applicationContext.getEnvironment()
            .getActiveNames()).containsExactly("test", "dev", "production");
      assertThat(applicationContext.getProperty("service.test.property", String.class)).isNotEmpty();
      assertThat(applicationContext.getProperty("service.test.property", String.class)
            .get()).isEqualTo("something-in-dev");
   }

   @Test
   public void whenEnvironmentIsSetToBothProductionAndDev_thenMissingPropertyIsEmpty() {
      ApplicationContext applicationContext = ApplicationContext.builder("dev", "production")
            .build();
      applicationContext.start();

      assertThat(applicationContext.getEnvironment()
            .getActiveNames()).containsExactly("test", "dev", "production");
      assertThat(applicationContext.getProperty("service.dummy.property", String.class)).isEmpty();
   }
}
