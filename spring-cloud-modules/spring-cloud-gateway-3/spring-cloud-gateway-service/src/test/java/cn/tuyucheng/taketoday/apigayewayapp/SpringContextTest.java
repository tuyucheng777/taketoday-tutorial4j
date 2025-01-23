package cn.tuyucheng.taketoday.apigayewayapp;

import cn.tuyucheng.taketoday.apigateway.ApiGatewayApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ApiGatewayApplication.class)
class SpringContextTest {

   @Test
   void whenSpringContextIsBootstrapped_thenNoExceptions() {
   }
}