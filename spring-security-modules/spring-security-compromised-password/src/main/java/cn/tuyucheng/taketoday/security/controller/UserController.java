package cn.tuyucheng.taketoday.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tuyucheng.taketoday.security.dto.UserCreationRequestDto;
import cn.tuyucheng.taketoday.security.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

   private final UserService userService;

   @PostMapping
   public ResponseEntity<Void> create(@RequestBody UserCreationRequestDto userCreationRequest) {
      userService.create(userCreationRequest);
      return ResponseEntity.ok().build();
   }
}