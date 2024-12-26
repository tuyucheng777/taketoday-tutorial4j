package cn.tuyucheng.taketoday.jpa.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan("cn.tuyucheng.taketoday.jpa.query")
//@EnableJpaRepositories("cn.tuyucheng.taketoday.jpa.query")
public class QueryApplication {

   public static void main(String[] args) {
      SpringApplication.run(QueryApplication.class, args);
   }
}