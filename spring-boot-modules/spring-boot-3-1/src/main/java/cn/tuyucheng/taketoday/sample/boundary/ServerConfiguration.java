package cn.tuyucheng.taketoday.sample.boundary;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerConfiguration implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

   @Override
   public void customize(TomcatServletWebServerFactory factory) {
      factory.addConnectorCustomizers(connector -> connector.setProperty("maxHttpResponseHeaderSize", "100000"));
   }
}