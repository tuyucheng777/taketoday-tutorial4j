package cn.tuyucheng.taketoday.dynamicquery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("cn.tuyucheng.taketoday.dynamicquery.repository")
public class DynamicQueryApplication {

   public static void main(String[] args) {
      SpringApplication.run(DynamicQueryApplication.class, args);
   }
}