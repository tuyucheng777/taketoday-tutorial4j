package cn.tuyucheng.taketoday.springvalidator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cn.tuyucheng.taketoday.spring.servicevalidation.SpringServiceLayerValidationApp;

@SpringBootApplication
public class UserApplication {
   public static void main(String[] args) {
      SpringApplication.run(UserApplication.class, args);
   }
}