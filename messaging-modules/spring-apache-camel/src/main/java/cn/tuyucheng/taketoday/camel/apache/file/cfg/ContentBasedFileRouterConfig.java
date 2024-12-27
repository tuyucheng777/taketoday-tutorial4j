package cn.tuyucheng.taketoday.camel.apache.file.cfg;

import cn.tuyucheng.taketoday.camel.apache.file.ContentBasedFileRouter;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

@Configuration
public class ContentBasedFileRouterConfig {

   @Bean
   ContentBasedFileRouter getContentBasedFileRouter() {
      return new ContentBasedFileRouter();
   }

   public List<RouteBuilder> routes() {
      return Collections.singletonList(getContentBasedFileRouter());
   }
}