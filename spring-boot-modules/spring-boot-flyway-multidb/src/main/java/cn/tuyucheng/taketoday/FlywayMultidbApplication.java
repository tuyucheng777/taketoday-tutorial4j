package cn.tuyucheng.taketoday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cn.tuyucheng.taketoday")
public class FlywayMultidbApplication {

   static void main(String[] args) {
      SpringApplication.run(FlywayMultidbApplication.class, args);
   }
}