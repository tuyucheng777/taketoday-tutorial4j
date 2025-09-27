package cn.tuyucheng.taketoday.customstatefulvalidation.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("cn.tuyucheng.taketoday.tenant")
public class TenantChannels {
   private String[] channels;

   public String[] getChannels() {
      return channels;
   }

   public void setChannels(String[] channels) {
      this.channels = channels;
   }
}