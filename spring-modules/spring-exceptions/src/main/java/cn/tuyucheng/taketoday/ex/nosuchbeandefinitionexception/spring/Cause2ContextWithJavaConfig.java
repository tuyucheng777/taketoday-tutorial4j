package cn.tuyucheng.taketoday.ex.nosuchbeandefinitionexception.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("cn.tuyucheng.taketoday.ex.nosuchbeandefinitionexception.cause2")
public class Cause2ContextWithJavaConfig {

   public Cause2ContextWithJavaConfig() {
      super();
   }

   // beans
}