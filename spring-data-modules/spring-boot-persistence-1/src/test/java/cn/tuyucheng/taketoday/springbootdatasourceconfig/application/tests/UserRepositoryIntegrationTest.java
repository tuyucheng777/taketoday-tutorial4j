package cn.tuyucheng.taketoday.springbootdatasourceconfig.application.tests;

import cn.tuyucheng.taketoday.springbootdatasourceconfig.application.entities.User;
import cn.tuyucheng.taketoday.springbootdatasourceconfig.application.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {

   @Autowired
   private UserRepository userRepository;

   @Test
   public void whenCalledSave_thenCorrectNumberOfUsers() {
      userRepository.save(new User("Bob", "bob@domain.com"));
      List<User> users = (List<User>) userRepository.findAll();

      // 2 additional users are saved in the CommandLineRunner bean
      assertThat(users.size()).isEqualTo(3);
   }
}