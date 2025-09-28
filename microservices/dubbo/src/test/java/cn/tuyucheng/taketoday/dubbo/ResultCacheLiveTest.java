package cn.tuyucheng.taketoday.dubbo;

import cn.tuyucheng.taketoday.dubbo.remote.GreetingsService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class ResultCacheLiveTest {

   private ClassPathXmlApplicationContext remoteContext;

   @Before
   public void initRemote() {
      remoteContext = new ClassPathXmlApplicationContext("multicast/provider-app-special.xml");
      remoteContext.start();
   }

   @Test
   public void givenProvider_whenConsumerSaysHi_thenGotResponse() {
      ClassPathXmlApplicationContext localContext = new ClassPathXmlApplicationContext("multicast/consumer-app.xml");
      localContext.start();
      GreetingsService greetingsService = (GreetingsService) localContext.getBean("greetingsService");

      long before = System.currentTimeMillis();
      String hiMessage = greetingsService.sayHi("taketoday");

      long timeElapsed = System.currentTimeMillis() - before;
      assertTrue(timeElapsed > 5000);
      assertNotNull(hiMessage);
      assertEquals("hi, taketoday", hiMessage);


      before = System.currentTimeMillis();
      hiMessage = greetingsService.sayHi("taketoday");
      timeElapsed = System.currentTimeMillis() - before;
      assertTrue(timeElapsed < 1000);
      assertNotNull(hiMessage);
      assertEquals("hi, taketoday", hiMessage);
   }
}