package cn.tuyucheng.taketoday.envvariables;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "taketoday")
public class TaketodayProperties {

   private String presentation;

   public String getPresentation() {
      return presentation;
   }

   public void setPresentation(String presentation) {
      this.presentation = presentation;
   }
}