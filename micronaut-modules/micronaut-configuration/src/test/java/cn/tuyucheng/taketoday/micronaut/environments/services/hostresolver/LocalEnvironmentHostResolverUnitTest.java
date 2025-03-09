package cn.tuyucheng.taketoday.micronaut.environments.services.hostresolver;

import cn.tuyucheng.taketoday.micronaut.environments.services.HostResolver;
import io.micronaut.context.ApplicationContext;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@MicronautTest(environments = {"local"})
public class LocalEnvironmentHostResolverUnitTest {

   @Inject
   HostResolver hostResolver;
   @Inject
   ApplicationContext applicationContext;

   @Test
   public void whenEnvironmentIsSetToLocal_thenActiveEnvironmentsAreTestAndLocal() {
      assertThat(applicationContext.getEnvironment()
            .getActiveNames()).containsExactlyInAnyOrder("test", "local");
   }

   @Test
   public void givenEnvironmentIsSetToLocal_whenGetHost_thenTheResolverReturnsLocalhost() {
      String localHost = hostResolver.getHost();

      assertThat(localHost).isEqualTo("localhost");
   }
}
