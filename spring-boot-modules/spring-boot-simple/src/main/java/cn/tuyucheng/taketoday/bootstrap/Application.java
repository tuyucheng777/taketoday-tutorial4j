package cn.tuyucheng.taketoday.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ServletComponentScan
@SpringBootApplication(scanBasePackages = "cn.tuyucheng.taketoday.bootstrap")
@EnableJpaRepositories("cn.tuyucheng.taketoday.bootstrap.persistence.repo")
@EntityScan("cn.tuyucheng.taketoday.bootstrap.persistence.model")
public class Application {

   public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
   }
}