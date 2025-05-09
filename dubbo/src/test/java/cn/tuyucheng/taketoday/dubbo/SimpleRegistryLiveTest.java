package cn.tuyucheng.taketoday.dubbo;

import cn.tuyucheng.taketoday.dubbo.remote.GreetingsService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SimpleRegistryLiveTest {

   private ClassPathXmlApplicationContext remoteContext;
   private ClassPathXmlApplicationContext registryContext;

   @Before
   public void initRemote() {
      registryContext = new ClassPathXmlApplicationContext("simple/registry.xml");
      registryContext.start();

      remoteContext = new ClassPathXmlApplicationContext("simple/provider-app.xml");
      remoteContext.start();
   }

   @Test
   public void givenProvider_whenConsumerSaysHi_thenGotResponse() {
      ClassPathXmlApplicationContext localContext = new ClassPathXmlApplicationContext("simple/consumer-app.xml");
      localContext.start();
      GreetingsService greetingsService = (GreetingsService) localContext.getBean("greetingsService");
      String hiMessage = greetingsService.sayHi("taketoday");

      assertNotNull(hiMessage);
      assertEquals("hi, taketoday", hiMessage);
   }
}