package cn.tuyucheng.taketoday.async;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springAsync-config.xml")
public class AsyncWithXMLIntegrationTest {

   @Autowired
   private AsyncComponent asyncAnnotationExample;

   @Test
   public void testAsyncAnnotationForMethodsWithVoidReturnType() throws InterruptedException {
      asyncAnnotationExample.asyncMethodWithVoidReturnType();
      Thread.sleep(2000);
   }
}