package cn.tuyucheng.taketoday.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import cn.tuyucheng.taketoday.configurationproperties.ConfigProperties;

@SpringBootApplication
@ComponentScan(basePackageClasses = {ConfigProperties.class, AdditionalProperties.class})
public class ConfigPropertiesDemoApplication {
   public static void main(String[] args) {
      SpringApplication.run(ConfigPropertiesDemoApplication.class, args);
   }
}