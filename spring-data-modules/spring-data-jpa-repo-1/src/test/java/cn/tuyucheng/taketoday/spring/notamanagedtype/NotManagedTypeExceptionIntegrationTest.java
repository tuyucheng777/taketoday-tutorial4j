package cn.tuyucheng.taketoday.spring.notamanagedtype;

import cn.tuyucheng.taketoday.spring.notamanagedtype.jakartaannotation.EntityWithJakartaAnnotationApplication;
import cn.tuyucheng.taketoday.spring.notamanagedtype.missedannotation.EntityWithoutAnnotationApplication;
import cn.tuyucheng.taketoday.spring.notamanagedtype.missedannotationfixed.EntityWithoutAnnotationFixedApplication;
import cn.tuyucheng.taketoday.spring.notamanagedtype.missedannotationfixed.EntityWithoutAnnotationFixedRepository;
import cn.tuyucheng.taketoday.spring.notamanagedtype.missedentityscan.app.WrongEntityScanApplication;
import cn.tuyucheng.taketoday.spring.notamanagedtype.missedentityscan.fixed.app.WrongEntityScanFixedApplication;
import cn.tuyucheng.taketoday.spring.notamanagedtype.missedentityscan.repository.CorrectEntityRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.boot.SpringApplication.run;

class NotManagedTypeExceptionIntegrationTest {
   @Test
   void givenEntityWithoutAnnotationApplication_whenBootstrap_thenExpectedExceptionThrown() {
      Exception exception = assertThrows(Exception.class,
            () -> run(EntityWithoutAnnotationApplication.class));

      assertThat(exception)
            .getRootCause()
            .hasMessageContaining("Not a managed type");
   }

   @Test
   void givenEntityWithoutAnnotationApplicationFixed_whenBootstrap_thenRepositoryBeanShouldBePresentInContext() {
      ConfigurableApplicationContext context = run(EntityWithoutAnnotationFixedApplication.class);
      EntityWithoutAnnotationFixedRepository repository = context
            .getBean(EntityWithoutAnnotationFixedRepository.class);

      assertThat(repository).isNotNull();
   }

   @Disabled
   @Test
   void givenEntityWithJakartaAnnotationApplication_whenBootstrap_thenExpectedExceptionThrown() {
      Exception exception = assertThrows(Exception.class,
            () -> run(EntityWithJakartaAnnotationApplication.class));

      assertThat(exception)
            .getRootCause()
            .hasMessageContaining("Not a managed type");
   }

   @Test
   void givenWrongEntityScanApplication_whenBootstrap_thenExpectedExceptionThrown() {
      Exception exception = assertThrows(Exception.class,
            () -> run(WrongEntityScanApplication.class));

      assertThat(exception)
            .getRootCause()
            .hasMessageContaining("Not a managed type");
   }

   @Test
   void givenWrongEntityScanApplicationFixed_whenBootstrap_thenRepositoryBeanShouldBePresentInContext() {
      SpringApplication app = new SpringApplication(WrongEntityScanFixedApplication.class);
      app.setAdditionalProfiles("test");
      ConfigurableApplicationContext context = app.run();
      CorrectEntityRepository repository = context
            .getBean(CorrectEntityRepository.class);

      assertThat(repository).isNotNull();
   }
}
