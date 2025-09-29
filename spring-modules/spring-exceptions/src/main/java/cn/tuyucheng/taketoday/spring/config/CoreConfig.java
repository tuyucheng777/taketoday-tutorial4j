package cn.tuyucheng.taketoday.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("cn.tuyucheng.taketoday.core")
public class CoreConfig implements WebMvcConfigurer {

   public CoreConfig() {
      super();
   }
}