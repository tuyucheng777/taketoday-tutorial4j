package cn.tuyucheng.taketoday.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ProfileManager {

   @Autowired
   private Environment environment;

   public void getActiveProfiles() {
      for (final String profileName : environment.getActiveProfiles()) {
         System.out.println(STR."Currently active profile - \{profileName}");
      }
   }
}