package cn.tuyucheng.taketoday.stream.sum;

import java.util.List;
import java.util.stream.Collectors;

public class StreamSumCalculatorWithObject {

   public static Integer getSumUsingCustomizedAccumulator(List<Item> items) {
      return items.stream()
            .map(Item::getPrice)
            .reduce(0, ArithmeticUtils::add);
   }

   public static Integer getSumUsingJavaAccumulator(List<Item> items) {
      return items.stream()
            .map(Item::getPrice)
            .reduce(0, Integer::sum);
   }

   public static Integer getSumUsingReduce(List<Item> items) {
      return items.stream()
            .map(Item::getPrice)
            .reduce(0, Integer::sum);
   }

   public static Integer getSumUsingCollect(List<Item> items) {
      return items.stream()
            .map(Item::getPrice)
            .collect(Collectors.summingInt(Integer::intValue));
   }

   public static Integer getSumUsingSum(List<Item> items) {
      return items.stream()
            .mapToInt(Item::getPrice)
            .sum();
   }
}