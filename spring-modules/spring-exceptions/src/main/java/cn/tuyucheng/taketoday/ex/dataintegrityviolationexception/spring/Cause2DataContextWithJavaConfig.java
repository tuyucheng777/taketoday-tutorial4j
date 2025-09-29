package cn.tuyucheng.taketoday.ex.dataintegrityviolationexception.spring;

import cn.tuyucheng.taketoday.spring.config.PersistenceConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("cn.tuyucheng.taketoday.ex.dataIntegrityviolationexception.cause2")
@Import(PersistenceConfig.class)
public class Cause2DataContextWithJavaConfig {

   public Cause2DataContextWithJavaConfig() {
      super();
   }

   // beans
}