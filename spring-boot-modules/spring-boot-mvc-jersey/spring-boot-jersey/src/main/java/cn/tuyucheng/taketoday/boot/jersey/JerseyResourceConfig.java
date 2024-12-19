package cn.tuyucheng.taketoday.boot.jersey;

import cn.tuyucheng.taketoday.boot.jersey.controllers.HelloController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyResourceConfig extends ResourceConfig {

   public JerseyResourceConfig() {
      super(HelloController.class);
   }
}