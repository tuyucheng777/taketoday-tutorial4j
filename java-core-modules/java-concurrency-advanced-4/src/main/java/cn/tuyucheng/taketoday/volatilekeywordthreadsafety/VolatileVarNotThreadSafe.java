package cn.tuyucheng.taketoday.volatilekeywordthreadsafety;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VolatileVarNotThreadSafe {

   private static final Logger LOG = LoggerFactory.getLogger(VolatileVarNotThreadSafe.class);
   private static volatile int count = 0;
   private static final int MAX_LIMIT = 1000;

   public static void increment() {
      count++;
   }

   public static int getCount() {
      return count;
   }

   public static void main(String[] args) throws InterruptedException {
      Thread t1 = new Thread(() -> {
         for (int index = 0; index < MAX_LIMIT; index++) {
            increment();
         }
      });

      Thread t2 = new Thread(() -> {
         for (int index = 0; index < MAX_LIMIT; index++) {
            increment();
         }
      });

      t1.start();
      t2.start();

      t1.join();
      t2.join();

      LOG.info("value of counter variable: {}", count);
   }
}