package cn.tuyucheng.taketoday.executorservicetest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ExecutorServiceUnitTest {

   @Test
   void whenNoBlocking_thenTestFails() {
      ExecutorService executorService = Executors.newSingleThreadExecutor();
      MyRunnable r = new MyRunnable();
      executorService.submit(r);
      assertNull(r.getResult());
   }

   @Test
   void whenUsingFuture_thenTestSucceeds() throws InterruptedException, ExecutionException {
      ExecutorService executorService = Executors.newSingleThreadExecutor();
      MyRunnable r = new MyRunnable();
      Future<?> future = executorService.submit(r);
      future.get();
      assertEquals(2305843005992468481L, r.getResult());
   }

   @Test
   void whenShuttingDownExecutorAndWait_thenTestSucceeds() throws InterruptedException {
      ExecutorService executorService = Executors.newSingleThreadExecutor();
      MyRunnable r = new MyRunnable();
      executorService.submit(r);
      executorService.shutdown();
      executorService.awaitTermination(10000, TimeUnit.SECONDS);
      assertEquals(2305843005992468481L, r.getResult());
   }

   @Test
   void whenUsingThreadPoolExecutor_thenTestSucceeds() throws InterruptedException {
      MyThreadPoolExecutor threadPoolExecutor = new MyThreadPoolExecutor(3, 6, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), 20);
      List<MyRunnable> runnables = new ArrayList<>();
      for (int i = 0; i < 20; i++) {
         MyRunnable r = new MyRunnable();
         runnables.add(r);
         threadPoolExecutor.submit(r);
      }
      threadPoolExecutor.waitDone();
      for (int i = 0; i < 20; i++) {
         assertEquals(2305843005992468481L, runnables.get(i).result);
      }
   }
}