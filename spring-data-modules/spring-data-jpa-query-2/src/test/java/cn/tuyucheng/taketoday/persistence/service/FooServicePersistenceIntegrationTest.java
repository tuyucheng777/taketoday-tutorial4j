package cn.tuyucheng.taketoday.persistence.service;

import cn.tuyucheng.taketoday.persistence.model.Foo;
import cn.tuyucheng.taketoday.spring.config.PersistenceTestConfig;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceTestConfig.class}, loader = AnnotationConfigContextLoader.class)
public class FooServicePersistenceIntegrationTest {

   @Autowired
   @Qualifier("fooHibernateService")
   private IFooService service;

   // tests

   @Test
   public final void whenContextIsBootstrapped_thenNoExceptions() {
      //
   }

   @Test
   public final void whenEntityIsCreated_thenNoExceptions() {
      service.create(new Foo(randomAlphabetic(6)));
   }

   @Test(expected = DataIntegrityViolationException.class)
   @Ignore("work in progress")
   public final void whenInvalidEntityIsCreated_thenDataException() {
      service.create(new Foo());
   }

   @Test(expected = DataIntegrityViolationException.class)
   public final void whenEntityWithLongNameIsCreated_thenDataException() {
      service.create(new Foo(randomAlphabetic(2048)));
   }

   @Test(expected = InvalidDataAccessApiUsageException.class)
   @Ignore("Right now, persist has saveOrUpdate semantics, so this will no longer fail")
   public final void whenSameEntityIsCreatedTwice_thenDataException() {
      final Foo entity = new Foo(randomAlphabetic(8));
      service.create(entity);
      service.create(entity);
   }

   @Test(expected = DataAccessException.class)
   public final void temp_whenInvalidEntityIsCreated_thenDataException() {
      service.create(new Foo(randomAlphabetic(2048)));
   }
}