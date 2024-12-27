package com.boot.camel.exception;

import cn.tuyucheng.taketoday.camel.boot.Application;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD;

@SpringBootTest(classes = Application.class)
@CamelSpringBootTest
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
class ExceptionThrowingRouteUnitTest {

   @Autowired
   private ProducerTemplate template;

   @Test
   @DirtiesContext
   void whenSendBody_thenExceptionRaisedSuccessfully() {
      CamelContext context = template.getCamelContext();
      Exchange exchange = context.getEndpoint("direct:start-exception")
            .createExchange(ExchangePattern.InOut);

      exchange.getIn().setBody("Hello Taketoday");
      Exchange out = template.send("direct:start-exception", exchange);

      assertTrue(out.isFailed(), "Should be failed");
      assertInstanceOf(IllegalArgumentException.class, out.getException(), "Should be IllegalArgumentException");
      assertEquals("An exception happened on purpose", out.getException().getMessage());
   }
}