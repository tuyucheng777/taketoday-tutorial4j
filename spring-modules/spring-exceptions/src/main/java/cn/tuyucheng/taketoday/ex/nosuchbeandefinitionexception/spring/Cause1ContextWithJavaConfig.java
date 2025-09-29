package cn.tuyucheng.taketoday.ex.nosuchbeandefinitionexception.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("cn.tuyucheng.taketoday.ex.nosuchbeandefinitionexception.cause1")
public class Cause1ContextWithJavaConfig {

   public Cause1ContextWithJavaConfig() {
      super();
   }

   // beans
}