package cn.tuyucheng.taketoday.jpa.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("cn.tuyucheng.taketoday.jpa.simple.repository")
public class JpaApplication {

   public static void main(String[] args) {
      SpringApplication.run(JpaApplication.class, args);
   }
}