package cn.tuyucheng.taketoday.micronaut.environments.services.hostresolver;

import cn.tuyucheng.taketoday.micronaut.environments.services.HostResolver;
import io.micronaut.context.ApplicationContext;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@MicronautTest(environments = {"production"})
public class ProductionEnvironmentHostResolverUnitTest {

   @Inject
   HostResolver hostResolver;
   @Inject
   ApplicationContext applicationContext;

   @Test
   public void whenEnvironmentIsSetToProduction_thenActiveEnvironmentsAreTestAndProduction() {
      assertThat(applicationContext.getEnvironment()
            .getActiveNames()).containsExactlyInAnyOrder("test", "production");
   }

   @Test
   public void givenEnvironmentIsSetToProduction_whenGetHost_thenTheResolverReturnsProdUrl() {
      String prodHost = hostResolver.getHost();

      assertThat(prodHost).isEqualTo("my-service.us-west-2.amazonaws.com");
   }
}