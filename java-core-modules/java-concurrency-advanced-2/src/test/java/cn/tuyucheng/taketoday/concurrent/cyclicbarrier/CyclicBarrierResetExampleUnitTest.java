package cn.tuyucheng.taketoday.concurrent.cyclicbarrier;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CyclicBarrierResetExampleUnitTest {

   @Test
   public void whenCyclicBarrier_reset() {
      CyclicBarrierResetExample ex = new CyclicBarrierResetExample(7, 20);
      int lineCount = ex.countWaits();
      assertTrue(lineCount > 7);
   }
}