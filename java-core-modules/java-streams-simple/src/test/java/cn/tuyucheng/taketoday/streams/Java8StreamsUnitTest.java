package cn.tuyucheng.taketoday.streams;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Java8StreamsUnitTest {

   private static List<String> list;

   @BeforeAll
   public static void init() {
      list = new ArrayList<>();
      list.add("One");
      list.add("OneAndOnly");
      list.add("Derek");
      list.add("Change");
      list.add("factory");
      list.add("justBefore");
      list.add("Italy");
      list.add("Italy");
      list.add("Thursday");
      list.add("");
      list.add("");
   }

   @Test
   public void checkStreamCount_whenCreating_givenDifferentSources() {
      String[] arr = new String[]{"a", "b", "c"};
      Stream<String> streamArr = Arrays.stream(arr);
      assertEquals(3, streamArr.count());

      Stream<String> streamOf = Stream.of("a", "b", "c");
      assertEquals(3, streamOf.count());

      long count = list.stream()
            .distinct()
            .count();
      assertEquals(9, count);
   }

   @Test
   void checkStreamCount_whenOperationFilter_thanCorrect() {
      Stream<String> streamFilter = list.stream()
            .filter(String::isEmpty);
      assertEquals(2, streamFilter.count());
   }

   @Test
   void checkStreamCount_whenOperationMap_thanCorrect() {
      List<String> uris = new ArrayList<>();
      uris.add("C:\\My.txt");
      Stream<Path> streamMap = uris.stream()
            .map(Paths::get);
      assertEquals(1, streamMap.count());

      List<Detail> details = new ArrayList<>();
      details.add(new Detail());
      details.add(new Detail());
      Stream<String> streamFlatMap = details.stream()
            .flatMap(detail -> detail.getParts()
                  .stream());
      assertEquals(4, streamFlatMap.count());
   }

   @Test
   void checkStreamCount_whenOperationMatch_thenCorrect() {
      boolean isValid = list.stream()
            .anyMatch(element -> element.contains("h"));
      boolean isValidOne = list.stream()
            .allMatch(element -> element.contains("h"));
      boolean isValidTwo = list.stream()
            .noneMatch(element -> element.contains("h"));
      assertTrue(isValid);
      assertFalse(isValidOne);
      assertFalse(isValidTwo);
   }

   @Test
   void checkStreamReducedValue_whenOperationReduce_thenCorrect() {
      List<Integer> integers = new ArrayList<>();
      integers.add(1);
      integers.add(1);
      integers.add(1);
      Integer reduced = integers.stream()
            .reduce(23, Integer::sum);
      assertTrue(reduced == 26);
   }

   @Test
   void checkStreamContains_whenOperationCollect_thenCorrect() {
      List<String> resultList = list.stream()
            .map(String::toUpperCase)
            .toList();
      assertEquals(resultList.size(), list.size());
      assertTrue(resultList.contains(""));
   }

   @Test
   public void checkParallelStream_whenDoWork() {
      list.parallelStream()
            .forEach(this::doWork);
   }

   private void doWork(String string) {
      assertTrue(true); // just imitate an amount of work
   }
}