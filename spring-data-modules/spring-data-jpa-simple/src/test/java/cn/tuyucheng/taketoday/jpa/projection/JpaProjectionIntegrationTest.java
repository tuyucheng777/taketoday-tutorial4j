package cn.tuyucheng.taketoday.jpa.projection;

import cn.tuyucheng.taketoday.jpa.projection.model.Person;
import cn.tuyucheng.taketoday.jpa.projection.repository.AddressRepository;
import cn.tuyucheng.taketoday.jpa.projection.repository.PersonRepository;
import cn.tuyucheng.taketoday.jpa.projection.view.AddressView;
import cn.tuyucheng.taketoday.jpa.projection.view.PersonDto;
import cn.tuyucheng.taketoday.jpa.projection.view.PersonView;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@DataJpaTest
@Sql(scripts = "/projection-insert-data.sql")
@Sql(scripts = "/projection-clean-up-data.sql", executionPhase = AFTER_TEST_METHOD)
@AutoConfigurationPackage(basePackages = "cn.tuyucheng.taketoday.jpa.projection")
class JpaProjectionIntegrationTest {
   @Autowired
   private AddressRepository addressRepository;

   @Autowired
   private PersonRepository personRepository;

   @Test
   void whenUsingClosedProjections_thenViewWithRequiredPropertiesIsReturned() {
      AddressView addressView = addressRepository.getAddressByState("CA").get(0);
      assertThat(addressView.getZipCode()).isEqualTo("90001");

      PersonView personView = addressView.getPerson();
      assertThat(personView.getFirstName()).isEqualTo("John");
      assertThat(personView.getLastName()).isEqualTo("Doe");
   }

   @Test
   void whenUsingOpenProjections_thenViewWithRequiredPropertiesIsReturned() {
      PersonView personView = personRepository.findByLastName("Doe");
      assertThat(personView.getFullName()).isEqualTo("John Doe");
   }

   @Test
   void whenUsingClassBasedProjectionsAndJPANativeQuery_thenDtoWithRequiredPropertiesIsReturned() {
      List<PersonDto> personDtos = personRepository.findByFirstNameLike("Jo%");
      assertThat(personDtos.size()).isEqualTo(2);
      assertThat(personDtos).isEqualTo(Arrays.asList(new PersonDto("John", "Doe"), new PersonDto("Job", "Dob")));
   }

   @Test
   void whenUsingClassBasedProjections_thenDtoWithRequiredPropertiesIsReturned() {
      PersonDto personDto = personRepository.findByFirstName("John");
      assertThat(personDto.firstName()).isEqualTo("John");
      assertThat(personDto.lastName()).isEqualTo("Doe");
   }

   @Test
   void whenUsingDynamicProjections_thenObjectWithRequiredPropertiesIsReturned() {
      Person person = personRepository.findByLastName("Doe", Person.class);
      PersonView personView = personRepository.findByLastName("Doe", PersonView.class);
      PersonDto personDto = personRepository.findByLastName("Doe", PersonDto.class);

      assertThat(person.getFirstName()).isEqualTo("John");
      assertThat(personView.getFirstName()).isEqualTo("John");
      assertThat(personDto.firstName()).isEqualTo("John");
   }
}