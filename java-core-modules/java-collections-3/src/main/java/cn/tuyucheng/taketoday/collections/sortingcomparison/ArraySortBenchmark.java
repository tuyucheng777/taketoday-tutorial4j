package cn.tuyucheng.taketoday.collections.sortingcomparison;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Measurement(batchSize = 100000, iterations = 10)
@Warmup(batchSize = 100000, iterations = 10)
public class ArraySortBenchmark {

   @State(Scope.Thread)
   public static class Initialize {
      Integer[] numbers = {-769214442, -1283881723, 1504158300, -1260321086, -1800976432, 1278262737, 1863224321, 1895424914, 2062768552, -1051922993, 751605209, -1500919212, 2094856518, -1014488489, -931226326, -1677121986, -2080561705, 562424208, -1233745158, 41308167};
      int[] primitives = {-769214442, -1283881723, 1504158300, -1260321086, -1800976432, 1278262737, 1863224321, 1895424914, 2062768552, -1051922993, 751605209, -1500919212, 2094856518, -1014488489, -931226326, -1677121986, -2080561705, 562424208, -1233745158, 41308167};
   }

   @Benchmark
   public Integer[] benchmarkArraysIntegerSort(ArraySortBenchmark.Initialize state) {
      Arrays.sort(state.numbers);
      return state.numbers;
   }

   @Benchmark
   public int[] benchmarkArraysIntSort(ArraySortBenchmark.Initialize state) {
      Arrays.sort(state.primitives);
      return state.primitives;
   }


   public static void main(String[] args) throws Exception {
      Options options = new OptionsBuilder()
            .include(ArraySortBenchmark.class.getSimpleName()).threads(1)
            .forks(1).shouldFailOnError(true)
            .shouldDoGC(true)
            .jvmArgs("-server").build();
      new Runner(options).run();
   }
}
