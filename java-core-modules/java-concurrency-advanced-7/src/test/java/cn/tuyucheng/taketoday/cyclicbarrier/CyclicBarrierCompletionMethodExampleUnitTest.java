package cn.tuyucheng.taketoday.cyclicbarrier;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CyclicBarrierCompletionMethodExampleUnitTest {

   @Test
   public void whenCyclicBarrier_countTrips() {
      CyclicBarrierCompletionMethodExample ex = new CyclicBarrierCompletionMethodExample(7, 20);
      int lineCount = ex.countTrips();
      assertEquals(2, lineCount);
   }
}