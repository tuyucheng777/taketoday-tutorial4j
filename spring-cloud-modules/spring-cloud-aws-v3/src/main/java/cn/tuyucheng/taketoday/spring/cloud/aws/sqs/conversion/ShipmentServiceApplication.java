package cn.tuyucheng.taketoday.spring.cloud.aws.sqs.conversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShipmentServiceApplication {

   public static void main(String[] args) {
      SpringApplication app = new SpringApplication(ShipmentServiceApplication.class);
      app.setAdditionalProfiles("shipping");
      app.run(args);
   }
}