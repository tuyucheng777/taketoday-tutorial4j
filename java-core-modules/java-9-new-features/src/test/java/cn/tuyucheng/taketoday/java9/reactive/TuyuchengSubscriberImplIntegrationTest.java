package cn.tuyucheng.taketoday.java9.reactive;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.Stopwatch;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TuyuchengSubscriberImplIntegrationTest {

   private static final int ITEM_SIZE = 10;
   private SubmissionPublisher<String> publisher;
   private TuyuchengSubscriberImpl<String> subscriber;

   @BeforeEach
   public void initialize() {
      // create Publisher with max buffer capacity 3.
      this.publisher = new SubmissionPublisher<String>(ForkJoinPool.commonPool(), 3);
      this.subscriber = new TuyuchengSubscriberImpl<String>();
      publisher.subscribe(subscriber);
   }

   @Rule
   public Stopwatch stopwatch = new Stopwatch() {

   };

   @Test
   public void testReactiveStreamCount() {
      IntStream.range(0, ITEM_SIZE)
            .forEach(item -> publisher.submit(item + ""));
      publisher.close();

      do {
         // wait for subscribers to complete all processing.
         try {
            Thread.sleep(100);
         } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      } while (!subscriber.isCompleted());

      int count = subscriber.getCounter();

      assertEquals(ITEM_SIZE, count);
   }

   @Test
   public void testReactiveStreamTime() {
      IntStream.range(0, ITEM_SIZE)
            .forEach(item -> publisher.submit(item + ""));
      publisher.close();

      do {
         // wait for subscribers to complete all processing.
         try {
            Thread.sleep(100);
         } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      } while (!subscriber.isCompleted());

      // The runtime in seconds should be equal to the number of items.
      assertTrue(stopwatch.runtime(TimeUnit.SECONDS) >= ITEM_SIZE);
   }

   @Test
   public void testReactiveStreamOffer() {
      IntStream.range(0, ITEM_SIZE)
            .forEach(item -> publisher.offer(item + "", (subscriber, string) -> {
               // Returning false means this item will be dropped (no retry), if blocked.
               return false;
            }));
      publisher.close();

      do {
         // wait for subscribers to complete all processing.
         try {
            Thread.sleep(100);
         } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      } while (!subscriber.isCompleted());

      int count = subscriber.getCounter();
      // Because 10 items were offered and the buffer capacity was 3, few items will not be processed.
      assertTrue(ITEM_SIZE > count);
   }

}
