package cn.tuyucheng.taketoday.spring.cloud.ribbon.client;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unused")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ServerLocationApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ServerLocationAppIntegrationTest {
   ConfigurableApplicationContext application2;
   ConfigurableApplicationContext application3;

   @BeforeEach
   void startApps() {
      this.application2 = startApp(9092);
      this.application3 = startApp(9999);
   }

   @AfterEach
   void closeApps() {
      this.application2.close();
      this.application3.close();
   }

   @LocalServerPort
   private int port;

   @Autowired
   private TestRestTemplate testRestTemplate;

   @Test
   void loadBalancingServersTest() {
      ResponseEntity<String> response = this.testRestTemplate.getForEntity("http://localhost:" + this.port + "/server-location", String.class);
      assertEquals(response.getBody(), "Australia");
   }

   private ConfigurableApplicationContext startApp(int port) {
      return SpringApplication.run(TestConfig.class, "--server.port=" + port, "--spring.jmx.enabled=false");
   }
}