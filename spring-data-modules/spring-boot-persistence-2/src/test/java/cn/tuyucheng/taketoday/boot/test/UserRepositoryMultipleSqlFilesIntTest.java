package cn.tuyucheng.taketoday.boot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tuyucheng.taketoday.boot.domain.User;
import cn.tuyucheng.taketoday.boot.repository.UserRepository;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by adam.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("multiplesqlfiles")
public class UserRepositoryMultipleSqlFilesIntTest {

   @Autowired
   private UserRepository userRepository;

   @Test
   public void givenTwoImportFilesWhenFindAllShouldReturnSixUsers() {
      Collection<User> users = userRepository.findAll();

      assertThat(users.size()).isEqualTo(6);
   }

}
