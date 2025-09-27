package cn.tuyucheng.taketoday.kafka.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cn.tuyucheng.taketoday.countingmessages.Application;

@SpringBootApplication
public class KafkaBatchApplication {

   public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
   }
}