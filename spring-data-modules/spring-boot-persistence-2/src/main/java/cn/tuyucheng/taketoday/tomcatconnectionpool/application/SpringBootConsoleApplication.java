package cn.tuyucheng.taketoday.tomcatconnectionpool.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"cn.tuyucheng.taketoday.tomcatconnectionpool.application"})
@EnableJpaRepositories(basePackages = "cn.tuyucheng.taketoday.tomcatconnectionpool.application.repositories")
@EnableTransactionManagement
@EntityScan(basePackages = "cn.tuyucheng.taketoday.tomcatconnectionpool.application.entities")
public class SpringBootConsoleApplication {

   public static void main(String[] args) {
      SpringApplication.run(SpringBootConsoleApplication.class);
   }
}
