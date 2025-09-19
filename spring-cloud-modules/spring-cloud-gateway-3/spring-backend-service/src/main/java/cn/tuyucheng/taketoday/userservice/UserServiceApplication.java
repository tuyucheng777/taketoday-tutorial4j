package cn.tuyucheng.taketoday.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application-backend.yml")
public class UserServiceApplication {
   static void main(String[] args) {
      SpringApplication.run(UserServiceApplication.class, args);
   }
}