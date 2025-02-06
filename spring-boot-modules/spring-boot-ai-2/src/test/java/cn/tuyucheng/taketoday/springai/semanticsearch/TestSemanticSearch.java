package cn.tuyucheng.taketoday.springai.semanticsearch;

import org.springframework.boot.SpringApplication;

public class TestSemanticSearch {

   public static void main(String[] args) {
      SpringApplication.from(Application::main).with(TestcontainersConfiguration.class).run(args);
   }
}