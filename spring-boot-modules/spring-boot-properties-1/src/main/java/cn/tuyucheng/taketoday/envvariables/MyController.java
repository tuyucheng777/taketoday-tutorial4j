package cn.tuyucheng.taketoday.envvariables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

   @Value("${environment.name}")
   private String environmentName;

   @Value("${java.home.and.environment}")
   private String javaHomeAndEnvironmentName;

   @Value("${thispropertydoesnotexist}")
   private String nonExistentProperty;

   @Value("${taketoday.presentation}")
   private String taketodayPresentation;

   @Autowired
   private Environment environment;

   @Autowired
   private TaketodayProperties taketodayProperties;

   @GetMapping("/environment_name")
   String getEnvironmentName_FromEnvironmentVariables() {
      return environmentName;
   }

   @GetMapping("/java_home_and_environment")
   String getJavaHomeAndEnvironmentName_FromEnvironmentVariables() {
      return javaHomeAndEnvironmentName;
   }

   @GetMapping("non_existent_property")
   String getNonexistentProperty_FromEnvironmentVariables() {
      return nonExistentProperty;
   }

   @GetMapping("taketoday_presentation_from_value")
   String getTaketodayPresentation_FromValue() {
      return taketodayPresentation;
   }

   @GetMapping("taketoday_presentation_from_environment")
   String getTaketodayPresentation_FromEnvironment() {
      return environment.getProperty("taketoday.presentation");
   }

   @GetMapping("taketoday_configuration_properties")
   String getTaketodayPresentation_FromConfigurationProperties() {
      return taketodayProperties.getPresentation();
   }
}