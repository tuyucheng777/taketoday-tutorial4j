package cn.tuyucheng.taketoday;

import cn.tuyucheng.taketoday.spring.data.redis.SpringRedisApplication;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import redis.embedded.RedisServerBuilder;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringRedisApplication.class)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
public class SpringContextLiveTest {

   private static redis.embedded.RedisServer redisServer;

   @BeforeAll
   public static void startRedisServer() {
      redisServer = new RedisServerBuilder().port(6379).setting("maxmemory 256M").build();
      redisServer.start();
   }

   @AfterAll
   public static void stopRedisServer() {
      redisServer.stop();
   }

   @Test
   public void whenSpringContextIsBootstrapped_thenNoExceptions() {
   }
}