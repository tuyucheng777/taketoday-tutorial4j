package cn.tuyucheng.taketoday.concurrent.cyclicbarrier;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class CyclicBarrierCountExampleUnitTest {

   @Test
   public void whenCyclicBarrier_notCompleted() {
      CyclicBarrierCountExample ex = new CyclicBarrierCountExample(2);
      boolean isCompleted = ex.callTwiceInSameThread();
      assertFalse(isCompleted);
   }
}