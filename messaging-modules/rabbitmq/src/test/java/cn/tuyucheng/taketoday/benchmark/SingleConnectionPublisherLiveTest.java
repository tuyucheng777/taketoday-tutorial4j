package cn.tuyucheng.taketoday.benchmark;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

class SingleConnectionPublisherLiveTest {

   @Test
   void whenSingleChannel_thenRunBenchmark() throws Exception {
      // host, workerCount, iterations, payloadSize
      Stream.of(1, 5, 10, 20, 50)
            .forEach(workers -> {
               SingleConnectionPublisher.main(new String[]{"localhost", Integer.toString(workers), "1000", "4096"});
            });
   }
}