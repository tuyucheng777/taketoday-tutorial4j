package cn.tuyucheng.taketoday.persistencecontext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "cn.tuyucheng.taketoday.persistencecontext")
public class PersistenceContextDemoApplication {
   public static void main(String[] args) {
      SpringApplication.run(PersistenceContextDemoApplication.class, args);
   }
}
