package cn.tuyucheng.taketoday.threadsafe;

import cn.tuyucheng.taketoday.billpugh.BillPughSingleton;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BillPughSingletonUnitTest {
   @Test
   void testThreadSafety() throws InterruptedException {
      int numberOfThreads = 10;
      CountDownLatch latch = new CountDownLatch(numberOfThreads);
      Set<BillPughSingleton> instances = ConcurrentHashMap.newKeySet();

      for (int i = 0; i < numberOfThreads; i++) {
         new Thread(() -> {
            instances.add(BillPughSingleton.getInstance());
            latch.countDown();
         }).start();
      }

      latch.await(5, TimeUnit.SECONDS);

      assertEquals(1, instances.size(), "All threads should get the same instance");
   }
}