package cn.tuyucheng.taketoday.camel.boot.conditional;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ConditionalBodyRouter extends RouteBuilder {

   @Override
   public void configure() throws Exception {
      from("direct:start-conditional")
            .routeId("conditional-body-route")
            .choice()
            .when(body().contains("Taketoday"))
            .setBody(simple("Goodbye, Taketoday!"))
            .to("mock:result-body")
            .otherwise()
            .to("mock:result-body")
            .end();
   }
}