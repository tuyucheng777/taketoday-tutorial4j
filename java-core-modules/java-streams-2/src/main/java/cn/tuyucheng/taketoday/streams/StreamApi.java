package cn.tuyucheng.taketoday.streams;

import java.util.List;
import java.util.stream.Stream;

public class StreamApi {

   public static String getLastElementUsingReduce(List<String> valueList) {
      Stream<String> stream = valueList.stream();
      return stream.reduce((_, second) -> second).orElse(null);
   }

   public static Integer getInfiniteStreamLastElementUsingReduce() {
      Stream<Integer> stream = Stream.iterate(0, i -> i + 1);
      return stream.limit(20).reduce((_, second) -> second).orElse(null);
   }

   public static String getLastElementUsingSkip(List<String> valueList) {
      long count = valueList.size();
      Stream<String> stream = valueList.stream();
      return stream.skip(count - 1).findFirst().orElse(null);
   }
}