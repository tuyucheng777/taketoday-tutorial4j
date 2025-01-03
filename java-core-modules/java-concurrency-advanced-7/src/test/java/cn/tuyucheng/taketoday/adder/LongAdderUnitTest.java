package cn.tuyucheng.taketoday.adder;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

import static com.jayway.awaitility.Awaitility.await;
import static junit.framework.TestCase.assertEquals;

public class LongAdderUnitTest {
   @Test
   public void givenMultipleThread_whenTheyWriteToSharedLongAdder_thenShouldCalculateSumForThem() throws InterruptedException {
      // given
      LongAdder counter = new LongAdder();
      ExecutorService executorService = Executors.newFixedThreadPool(8);

      int numberOfThreads = 4;
      int numberOfIncrements = 100;

      // when
      Runnable incrementAction = () -> IntStream
            .range(0, numberOfIncrements)
            .forEach((i) -> counter.increment());

      for (int i = 0; i < numberOfThreads; i++) {
         executorService.execute(incrementAction);
      }

      // then
      executorService.awaitTermination(500, TimeUnit.MILLISECONDS);
      executorService.shutdown();

      assertEquals(numberOfIncrements * numberOfThreads, counter.sum());
      assertEquals(numberOfIncrements * numberOfThreads, counter.sum());
   }

   @Test
   public void givenMultipleThread_whenTheyWriteToSharedLongAdder_thenShouldCalculateSumForThemAndResetAdderAfterward() throws InterruptedException {
      // given
      LongAdder counter = new LongAdder();
      ExecutorService executorService = Executors.newFixedThreadPool(8);

      int numberOfThreads = 4;
      int numberOfIncrements = 100;

      // when
      Runnable incrementAction = () -> IntStream
            .range(0, numberOfIncrements)
            .forEach((i) -> counter.increment());

      for (int i = 0; i < numberOfThreads; i++) {
         executorService.execute(incrementAction);
      }

      // then
      executorService.awaitTermination(500, TimeUnit.MILLISECONDS);
      executorService.shutdown();

      assertEquals(numberOfIncrements * numberOfThreads, counter.sumThenReset());

      await().until(() -> assertEquals(0, counter.sum()));
   }
}