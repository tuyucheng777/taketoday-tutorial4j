package cn.tuyucheng.taketoday.hexagonal.service;

import org.springframework.stereotype.Service;

import cn.tuyucheng.taketoday.hexagonal.persistence.repository.UserRepository;

@Service
public class UserService {

   private final UserRepository userRepository;

   public UserService(UserRepository userRepository) {
      this.userRepository = userRepository;
   }
}