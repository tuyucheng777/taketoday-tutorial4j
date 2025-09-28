package cn.tuyucheng.taketoday.dubbo;

import cn.tuyucheng.taketoday.dubbo.remote.GreetingsService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertNull;

public class ClusterFailsafeLiveTest {

   private ExecutorService executorService;

   @Before
   public void initRemote() {
      executorService = Executors.newFixedThreadPool(1);
      executorService.submit(() -> {
         ClassPathXmlApplicationContext remoteContext = new ClassPathXmlApplicationContext("cluster/provider-app-special-failsafe.xml");
         remoteContext.start();
      });
   }

   @Test
   public void givenProviderCluster_whenConsumerSaysHi_thenGotFailsafeResponse() {
      ClassPathXmlApplicationContext localContext = new ClassPathXmlApplicationContext("cluster/consumer-app-failtest.xml");
      localContext.start();
      GreetingsService greetingsService = (GreetingsService) localContext.getBean("greetingsService");
      String hiMessage = greetingsService.sayHi("taketoday");

      assertNull(hiMessage);
   }

   @After
   public void destroy() {
      executorService.shutdown();
   }
}