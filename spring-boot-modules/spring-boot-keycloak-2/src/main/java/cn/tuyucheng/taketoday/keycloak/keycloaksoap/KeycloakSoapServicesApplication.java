package cn.tuyucheng.taketoday.keycloak.keycloaksoap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class KeycloakSoapServicesApplication {

   @Autowired
   private Environment environment;

   public static void main(String[] args) {
      SpringApplication application = new SpringApplication(KeycloakSoapServicesApplication.class);
      application.setAdditionalProfiles("keycloak");
      application.run(args);
   }
}