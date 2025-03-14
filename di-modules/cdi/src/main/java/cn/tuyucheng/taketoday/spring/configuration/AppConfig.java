package cn.tuyucheng.taketoday.spring.configuration;

import cn.tuyucheng.taketoday.spring.aspect.SpringTestAspect;
import cn.tuyucheng.taketoday.spring.service.SpringSuperService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
   @Bean
   public SpringSuperService springSuperService() {
      return new SpringSuperService();
   }

   @Bean
   public SpringTestAspect springTestAspect() {
      return new SpringTestAspect();
   }

   @Bean
   public List<String> getAccumulator() {
      return new ArrayList<String>();
   }
}