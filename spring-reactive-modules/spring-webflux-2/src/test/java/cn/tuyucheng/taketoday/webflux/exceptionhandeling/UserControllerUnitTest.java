package cn.tuyucheng.taketoday.webflux.exceptionhandeling;

import cn.tuyucheng.taketoday.webflux.exceptionhandeling.ex.NotFoundException;
import cn.tuyucheng.taketoday.webflux.exceptionhandeling.model.User;
import cn.tuyucheng.taketoday.webflux.exceptionhandeling.repository.UserRepository;
import cn.tuyucheng.taketoday.webflux.exceptionhandeling.service.UserService;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class UserControllerUnitTest {
   UserRepository repositoryMock = mock(UserRepository.class);
   private final UserService userService = new UserService(repositoryMock);

   @Test
   public void givenNonExistUser_whenFailureCall_then_Throws_exception() {
      assertThrows(NotFoundException.class, () -> userService.getUserByIdThrowingException("3"));
   }

   @Test
   public void givenNonExistUser_whenFailureCall_then_returnMonoError() {
      Mono<User> result = userService.getUserByIdUsingMonoError("3");
      StepVerifier.create(result)
            .expectError(NotFoundException.class)
            .verify();
   }
}