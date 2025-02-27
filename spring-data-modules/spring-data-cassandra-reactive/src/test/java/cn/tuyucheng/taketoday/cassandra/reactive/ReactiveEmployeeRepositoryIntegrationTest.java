package cn.tuyucheng.taketoday.cassandra.reactive;

import cn.tuyucheng.taketoday.cassandra.reactive.model.Employee;
import cn.tuyucheng.taketoday.cassandra.reactive.repository.EmployeeRepository;
import org.cassandraunit.spring.CassandraDataSet;
import org.cassandraunit.spring.CassandraUnitDependencyInjectionTestExecutionListener;
import org.cassandraunit.spring.CassandraUnitTestExecutionListener;
import org.cassandraunit.spring.EmbeddedCassandra;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.web.ServletTestExecutionListener;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestExecutionListeners(listeners = {
      CassandraUnitDependencyInjectionTestExecutionListener.class,
      CassandraUnitTestExecutionListener.class,
      ServletTestExecutionListener.class,
      DependencyInjectionTestExecutionListener.class,
      DirtiesContextTestExecutionListener.class
})
@EmbeddedCassandra(timeout = 60000, configuration = "cassandra-server.yaml")
@CassandraDataSet(value = {"cassandra-init.cql"}, keyspace = "practice")
class ReactiveEmployeeRepositoryIntegrationTest {

   @Autowired
   EmployeeRepository repository;

   @BeforeEach
   void setUp() {
      Flux<Employee> deleteAndInsert = repository.deleteAll() //
            .thenMany(repository.saveAll(Flux.just(
                  new Employee(111, "John Doe", "Delaware", "jdoe@xyz.com", 31),
                  new Employee(222, "Adam Smith", "North Carolina", "asmith@xyz.com", 43),
                  new Employee(333, "Kevin Dunner", "Virginia", "kdunner@xyz.com", 24),
                  new Employee(444, "Mike Lauren", "New York", "mlauren@xyz.com", 41))));

      StepVerifier.create(deleteAndInsert).expectNextCount(4).verifyComplete();
   }

   @Test
   void givenRecordsAreInserted_whenDbIsQueried_thenShouldIncludeNewRecords() {
      Mono<Long> saveAndCount = repository.count()
            .doOnNext(System.out::println)
            .thenMany(repository.saveAll(Flux.just(new Employee(325, "Kim Jones", "Florida", "kjones@xyz.com", 42),
                  new Employee(654, "Tom Moody", "New Hampshire", "tmoody@xyz.com", 44))))
            .last()
            .flatMap(v -> repository.count())
            .doOnNext(System.out::println);

      StepVerifier.create(saveAndCount).expectNext(6L).verifyComplete();
   }

   @Test
   void givenAgeForFilter_whenDbIsQueried_thenShouldReturnFilteredRecords() {
      StepVerifier.create(repository.findByAgeGreaterThan(35)).expectNextCount(2).verifyComplete();
   }
}