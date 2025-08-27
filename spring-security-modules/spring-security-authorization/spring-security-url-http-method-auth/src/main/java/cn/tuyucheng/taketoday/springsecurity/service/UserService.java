package cn.tuyucheng.taketoday.springsecurity.service;

import cn.tuyucheng.taketoday.springsecurity.dto.request.RegisterRequestDto;
import cn.tuyucheng.taketoday.springsecurity.dto.UserProfileDto;
import cn.tuyucheng.taketoday.springsecurity.entity.User;
import cn.tuyucheng.taketoday.springsecurity.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
   private final UserRepository userRepository;
   private final PasswordEncoder passwordEncoder;

   public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
      this.userRepository = userRepository;
      this.passwordEncoder = passwordEncoder;
   }

   public String register(RegisterRequestDto request) {
      if (userRepository.findByUsername(request.getUsername()).isPresent()) {
         return "Username already exists";
      }

      User user = new User();
      user.setUsername(request.getUsername());
      user.setEmail(request.getEmail());
      user.setPassword(passwordEncoder.encode(request.getPassword()));
      user.setRole(request.getRole());

      userRepository.save(user);
      return "User registered successfully";
   }

   public UserProfileDto profile(String username) {
      Optional<User> user = userRepository.findByUsername(username);
      return user.map(value -> new UserProfileDto(value.getUsername(), value.getEmail(), value.getRole())).orElseThrow();
   }

   public User getUser(String username) {
      Optional<User> user = userRepository.findByUsername(username);
      return user.orElse(null);
   }
}