package cn.tuyucheng.taketoday.propertyexpansion.components;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyLoggerBean {

   private static final Logger log = LoggerFactory.getLogger(PropertyLoggerBean.class);

   @Value("${expanded.project.version}")
   private String projectVersion;

   @Value("${expanded.project.property}")
   private String projectProperty;

   @PostConstruct
   public void printProperties() {
      log.info("");
      log.info("Properties logged from logger bean");
      log.info("===========================================");
      log.info("Project version : {}", projectVersion);
      log.info("Project property : {}", projectProperty);
      log.info("===========================================");
      log.info("");
   }
}