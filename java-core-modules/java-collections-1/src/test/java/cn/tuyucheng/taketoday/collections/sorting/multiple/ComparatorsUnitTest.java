package cn.tuyucheng.taketoday.collections.sorting.multiple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComparatorsUnitTest {
   @Test
   public void givenPersonsList_whenComparedOnTwoFields_thenReturnCorrectOrder() {
      Person person1 = new Person("John", 21);
      Person person2 = new Person("Tom", 20);
      // Another employee named John
      Person person3 = new Person("John", 22);

      List<Comparator<Person>> comparators =
            Arrays.asList(new CheckFieldsOneByOne(),
                  new ComparisonChainExample(),
                  new CompareToBuilderExample(),
                  ComparatorLambda.createEmployeeComparator());
      // All comparators should produce the same result
      for (Comparator<Person> comparator : comparators) {
         Assertions.assertIterableEquals(
               Stream.of(person1, person2, person3)
                     .sorted(comparator)
                     .collect(Collectors.toList()),
               Arrays.asList(person1, person3, person2));
      }
   }
}