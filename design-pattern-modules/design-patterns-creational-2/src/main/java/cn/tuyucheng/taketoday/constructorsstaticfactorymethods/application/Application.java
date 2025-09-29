package cn.tuyucheng.taketoday.constructorsstaticfactorymethods.application;

import cn.tuyucheng.taketoday.constructorsstaticfactorymethods.entities.User;

public class Application {

   static void main() {
      User user1 = User.createWithDefaultCountry("John", "john@domain.com");
      User user2 = User.createWithLoggedInstantiationTime("John", "john@domain.com", "Argentina");
      User user3 = User.getSingletonInstance("John", "john@domain.com", "Argentina");
   }
}