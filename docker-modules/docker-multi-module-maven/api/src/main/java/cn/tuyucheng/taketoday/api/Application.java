package cn.tuyucheng.taketoday.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Application {

   public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
   }

   @Configuration
   @EntityScan(basePackages = "cn.tuyucheng.taketoday.domain")
   @EnableJpaRepositories(basePackages = "cn.tuyucheng.taketoday.domain")
   static class Config {
   }
}