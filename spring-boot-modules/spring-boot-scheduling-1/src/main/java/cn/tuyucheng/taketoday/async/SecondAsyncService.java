package cn.tuyucheng.taketoday.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class SecondAsyncService {

   @Async
   public CompletableFuture<String> asyncGetData() throws InterruptedException {
      Thread.sleep(4000);
      return new AsyncResult<>(super.getClass().getSimpleName() + " response !!! ").completable();
   }
}