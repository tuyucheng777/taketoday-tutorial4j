package cn.tuyucheng.taketoday.springai.huggingface;

import org.springframework.boot.SpringApplication;
import org.testcontainers.utility.TestcontainersConfiguration;

public class TestApplication {

   public static void main(String[] args) {
      SpringApplication.from(Application::main)
            .with(TestcontainersConfiguration.class)
            .run(args);
   }
}