package cn.tuyucheng.taketoday.messaging.postgresql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import cn.tuyucheng.taketoday.messaging.postgresql.domain.Order;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql("/schema.sql")
class ApplicationLiveTest {


   @LocalServerPort
   int localPort;

   @Autowired
   TestRestTemplate client;

   @Test
   void whenCreateBuyOrder_thenSuccess() {
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

      MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
      data.add("symbol", "BAEL");
      data.add("price", "14.56");
      data.add("quantity", "100");
      HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(data, headers);

      client.postForEntity("http://localhost:" + localPort + "/orders/buy", data, Order.class);
   }
}