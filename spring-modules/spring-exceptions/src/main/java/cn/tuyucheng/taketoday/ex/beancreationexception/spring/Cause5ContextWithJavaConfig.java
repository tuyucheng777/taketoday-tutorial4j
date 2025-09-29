package cn.tuyucheng.taketoday.ex.beancreationexception.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("cn.tuyucheng.taketoday.ex.beancreationexception.cause5")
public class Cause5ContextWithJavaConfig {

   public Cause5ContextWithJavaConfig() {
      super();
   }

   // beans
}