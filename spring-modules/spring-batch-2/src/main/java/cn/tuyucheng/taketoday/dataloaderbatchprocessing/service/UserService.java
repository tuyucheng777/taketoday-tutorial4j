package cn.tuyucheng.taketoday.dataloaderbatchprocessing.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import cn.tuyucheng.taketoday.dataloaderbatchprocessing.entity.User;
import cn.tuyucheng.taketoday.dataloaderbatchprocessing.repository.UserRepository;

@Service
public class UserService {
   private final UserRepository userRepository;

   public UserService(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   public CompletableFuture<List<User>> getUsersByIds(List<String> ids) {
      return CompletableFuture.supplyAsync(() -> userRepository.findAllById(ids));
   }
}