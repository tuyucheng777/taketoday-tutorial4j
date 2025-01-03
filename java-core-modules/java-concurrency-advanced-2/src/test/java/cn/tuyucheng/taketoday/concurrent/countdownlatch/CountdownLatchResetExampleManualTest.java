package cn.tuyucheng.taketoday.concurrent.countdownlatch;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CountdownLatchResetExampleManualTest {

   @Test
   public void whenCountDownLatch_noReset() {
      CountdownLatchResetExample ex = new CountdownLatchResetExample(7, 20);
      int lineCount = ex.countWaits();
      assertTrue(lineCount <= 7);
   }
}