package cn.tuyucheng.taketoday.camel.boot.boot.testing;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class GreetingsFileRouter extends RouteBuilder {

   @Override
   public void configure() throws Exception {
      from("direct:start")
            .routeId("greetings-route")
            .setBody(constant("Hello Taketoday Readers!"))
            .to("file:output");
   }
}