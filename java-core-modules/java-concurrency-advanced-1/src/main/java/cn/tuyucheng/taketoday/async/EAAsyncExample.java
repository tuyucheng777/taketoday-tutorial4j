package cn.tuyucheng.taketoday.async;

import com.ea.async.Async;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

import static com.ea.async.Async.await;

public class EAAsyncExample {

   private static final Logger log = LoggerFactory.getLogger(EAAsyncExample.class);

   static {
      Async.init();
   }

   public static void main() throws Exception {
      usingCompletableFuture();
      usingAsyncAwait();
   }

   public static void usingCompletableFuture() throws Exception {
      CompletableFuture<Void> completableFuture = hello()
            .thenComposeAsync(EAAsyncExample::mergeWorld)
            .thenAcceptAsync(EAAsyncExample::print)
            .exceptionally(throwable -> {
               log.error(String.valueOf(throwable.getCause()));
               return null;
            });
      completableFuture.get();
   }

   public static CompletableFuture<String> hello() {
      return CompletableFuture.supplyAsync(() -> "Hello");
   }

   public static CompletableFuture<String> mergeWorld(String s) {
      return CompletableFuture.supplyAsync(() -> s + " World!");
   }

   public static void print(String str) {
      CompletableFuture.runAsync(() -> System.out.println(str));
   }

   private static void usingAsyncAwait() {
      try {
         String hello = await(hello());
         String helloWorld = await(mergeWorld(hello));
         await(CompletableFuture.runAsync(() -> print(helloWorld)));
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}