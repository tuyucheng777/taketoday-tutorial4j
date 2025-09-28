package cn.tuyucheng.taketoday.failsafe;

import dev.failsafe.Failsafe;
import dev.failsafe.FailsafeException;
import dev.failsafe.Timeout;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TimeoutUnitTest {
   @Test
   void testTimeout() {
      Timeout<Object> timeout = Timeout.builder(Duration.ofMillis(100)).build();

      long start = System.currentTimeMillis();
      assertThrows(FailsafeException.class, () ->
            Failsafe.with(timeout)
                  .get(() -> {
                     Thread.sleep(250);
                     return 2;
                  })
      );
      long end = System.currentTimeMillis();
      long duration = end - start;

      Assertions.assertTrue(duration >= 100); // Our timeout
      Assertions.assertTrue(duration <= 300); // 250ms plus a bit.
   }

   @Test
   void testInterruption() {
      Timeout<Object> timeout = Timeout.builder(Duration.ofMillis(100))
            .withInterrupt()
            .build();

      long start = System.currentTimeMillis();
      assertThrows(FailsafeException.class, () ->
            Failsafe.with(timeout)
                  .get(() -> {
                     Thread.sleep(250);
                     return 2;
                  })
      );
      long end = System.currentTimeMillis();
      long duration = end - start;

      Assertions.assertTrue(duration >= 100); // Our timeout
      Assertions.assertTrue(duration <= 150); // Our timeout plus a bit. Notably less than our task takes.
   }
}