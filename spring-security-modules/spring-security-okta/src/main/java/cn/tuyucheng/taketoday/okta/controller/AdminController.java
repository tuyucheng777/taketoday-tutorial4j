package cn.tuyucheng.taketoday.okta.controller;

import com.okta.sdk.client.Client;
import com.okta.sdk.resource.user.User;
import com.okta.sdk.resource.user.UserBuilder;
import com.okta.sdk.resource.user.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

   @Autowired
   public Client client;

   @GetMapping("/users")
   public UserList getUsers() {
      return client.listUsers();
   }

   @GetMapping("/user")
   public UserList searchUserByEmail(@RequestParam String query) {
      return client.listUsers(query, null, null, null, null);
   }

   @GetMapping("/createUser")
   public User createUser() {
      char[] tempPassword = {'P', 'a', '$', '$', 'w', '0', 'r', 'd'};
      return UserBuilder.instance()
            .setEmail("norman.lewis@email.com")
            .setFirstName("Norman")
            .setLastName("Lewis")
            .setPassword(tempPassword)
            .setActive(true)
            .buildAndCreate(client);
   }
}