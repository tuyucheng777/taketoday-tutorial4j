package cn.tuyucheng.taketoday.webflux.exceptionhandeling.service;

import cn.tuyucheng.taketoday.webflux.exceptionhandeling.ex.NotFoundException;
import cn.tuyucheng.taketoday.webflux.exceptionhandeling.model.User;
import cn.tuyucheng.taketoday.webflux.exceptionhandeling.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

public class UserService {

   private final UserRepository userRepository;

   @Autowired
   public UserService(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   public Mono<User> getUserByIdThrowingException(String id) {
      User user = userRepository.findById(id);
      if (user == null)
         throw new NotFoundException("User Not Found");
      return Mono.justOrEmpty(user);
   }

   public Mono<User> getUserByIdUsingMonoError(String id) {
      User user = userRepository.findById(id);
      return (user != null) ? Mono.justOrEmpty(user) : Mono.error(new NotFoundException("User Not Found"));
   }
}