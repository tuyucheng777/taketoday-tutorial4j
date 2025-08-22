package cn.tuyucheng.taketoday.restclient;


import org.junit.jupiter.api.Test;
import org.springframework.http.client.ClientHttpRequestInterceptor;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


class InterceptingClientHttpRequestTest {

   @Test
   void updateRequestAttribute() throws Exception {
      String attrName = "attr1";
      String attrValue = "value1";

      assertDoesNotThrow(() -> {
         ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
            request.getAttributes().put(attrName, attrValue);
            return execution.execute(request, body);
         };
      });
   }
}
