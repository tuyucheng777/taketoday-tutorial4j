package cn.tuyucheng.taketoday.javapoet.test.person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Student implements Person {
   private String name;

   @Override
   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void printNameMultipleTimes() {
      List<String> names = new ArrayList<>();
      IntStream.range(0, 10).forEach(_ -> names.add(name));
      names.forEach(System.out::println);
   }

   public static void sortByLength(List<String> strings) {
      strings.sort(Comparator.comparingInt(String::length));
   }
}