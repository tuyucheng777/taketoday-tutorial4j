package cn.tuyucheng.taketoday.boot;

import cn.tuyucheng.taketoday.jpa.JpaApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "cn.tuyucheng.taketoday.boot.daos")
@EntityScan({"cn.tuyucheng.taketoday.boot.domain"})
@ComponentScan("cn.tuyucheng.taketoday.boot.daos")
public class BootApplication {
   public static void main(String[] args) {
      SpringApplication.run(JpaApplication.class, args);
   }

}
