package cn.tuyucheng.taketoday.springpagination.service;

import org.springframework.stereotype.Service;

import cn.tuyucheng.taketoday.springpagination.model.Preference;
import cn.tuyucheng.taketoday.springpagination.model.User;

@Service
public class UserService implements IUserService {

   @Override
   public User getCurrentUser() {
      Preference preference = new Preference();
      preference.setId(1L);
      preference.setTimezone("Asia/Calcutta");

      User user = new User();
      user.setId(1L);
      user.setName("Micheal");
      user.setPreference(preference);

      return user;
   }
}