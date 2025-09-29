package cn.tuyucheng.taketoday.ex.beancreationexception.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("cn.tuyucheng.taketoday.ex.beancreationexception.cause8")
public class Cause8ContextWithJavaConfig {

   public Cause8ContextWithJavaConfig() {
      super();
   }

   // beans
}