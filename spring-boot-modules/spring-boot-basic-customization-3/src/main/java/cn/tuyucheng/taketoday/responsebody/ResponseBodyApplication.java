package cn.tuyucheng.taketoday.responsebody;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cn.tuyucheng.taketoday.responsebody")
public class ResponseBodyApplication {

   public static void main(String[] args) {
      SpringApplication.run(ResponseBodyApplication.class, args);
   }
}