package cn.tuyucheng.taketoday.ex.beandefinitionstoreexception.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("cn.tuyucheng.taketoday.ex.beandefinitionstoreexception.cause3")
public class Cause3ContextWithJavaConfig {

   public Cause3ContextWithJavaConfig() {
      super();
   }

   // beans
}