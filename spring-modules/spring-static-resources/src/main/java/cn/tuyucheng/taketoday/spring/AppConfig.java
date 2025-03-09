package cn.tuyucheng.taketoday.spring;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = {"cn.tuyucheng.taketoday.persistence.service", "cn.tuyucheng.taketoday.persistence.dao"})
@Import({MvcConfig.class, SecSecurityConfig.class})
@PropertySource("classpath:application.properties")
public class AppConfig {

   @Bean
   public static PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
      return new PropertySourcesPlaceholderConfigurer();
   }
}