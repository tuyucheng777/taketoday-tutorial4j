package cn.tuyucheng.taketoday.micronaut.environments.services.eventsourcing;

import io.micronaut.context.ApplicationContext;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@MicronautTest(environments = {"production"})
public class ProductionEnvironmentEventSourcingUnitTest {

   @Inject
   EventSourcingService eventSourcingService;
   @Inject
   ApplicationContext applicationContext;

   @Test
   public void whenEnvironmentIsSetToProduction_thenActiveEnvironmentsAreTestAndProduction() {
      assertThat(applicationContext.getEnvironment()
            .getActiveNames()).containsExactlyInAnyOrder("test", "production");
   }

   @Test
   public void givenEnvironmentIsSetToProduction_whenSendEvent_thenKafkaServiceIsUsed() {
      String devEvent = eventSourcingService.sendEvent("something");

      assertThat(devEvent).isEqualTo("using kafka to send message: [something]");
   }
}
