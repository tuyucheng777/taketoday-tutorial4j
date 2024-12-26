package cn.tuyucheng.taketoday.spring.notamanagedtype.missedentityscan.fixed.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages =
      "cn.tuyucheng.taketoday.spring.notamanagedtype.missedentityscan.repository")
@EntityScan("cn.tuyucheng.taketoday.spring.notamanagedtype.missedentityscan.entity")
public class WrongEntityScanFixedApplication {

}