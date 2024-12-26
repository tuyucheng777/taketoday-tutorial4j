package cn.tuyucheng.taketoday.spring.notamanagedtype.missedentityscan.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages =
      "cn.tuyucheng.taketoday.spring.notamanagedtype.missedentityscan.repository")
public class WrongEntityScanApplication {

}