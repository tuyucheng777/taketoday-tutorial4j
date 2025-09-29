package cn.tuyucheng.taketoday.cassecuredapp.service;

import cn.tuyucheng.taketoday.cassecuredapp.user.CasUser;
import cn.tuyucheng.taketoday.cassecuredapp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

public class CasUserDetailsService implements UserDetailsService {

   @Autowired
   private UserRepository userRepository;

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      // Get the user from the database.
      CasUser casUser = getUserFromDatabase(username);

      // Create a UserDetails object.

      return new User(
            casUser.getEmail(),
            casUser.getPassword(),
            Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN")));
   }

   private CasUser getUserFromDatabase(String username) {
      return userRepository.findByEmail(username);
   }
}