package cn.tuyucheng.taketoday.streams.collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class CollectorImprovementUnitTest {

   @Test
   void givenList_whenSatifyPredicate_thenMapValueWithOccurences() {
      List<Integer> numbers = List.of(1, 2, 3, 5, 5);

      Map<Integer, Long> result = numbers.stream()
            .filter(val -> val > 3)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

      Assertions.assertEquals(1, result.size());

      result = numbers.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.filtering(val -> val > 3, Collectors.counting())));

      Assertions.assertEquals(4, result.size());
   }

   @Test
   void givenListOfBlogs_whenAuthorName_thenMapAuthorWithComments() {
      Blog blog1 = new Blog("1", "Nice", "Very Nice");
      Blog blog2 = new Blog("2", "Disappointing", "Ok", "Could be better");
      List<Blog> blogs = List.of(blog1, blog2);

      Map<String, List<List<String>>> authorComments1 = blogs.stream()
            .collect(Collectors.groupingBy(Blog::getAuthorName, Collectors.mapping(Blog::getComments, Collectors.toList())));

      Assertions.assertEquals(2, authorComments1.size());
      Assertions.assertEquals(2, authorComments1.get("1")
            .get(0)
            .size());
      Assertions.assertEquals(3, authorComments1.get("2")
            .get(0)
            .size());

      Map<String, List<String>> authorComments2 = blogs.stream()
            .collect(Collectors.groupingBy(Blog::getAuthorName, Collectors.flatMapping(blog -> blog.getComments()
                  .stream(), Collectors.toList())));

      Assertions.assertEquals(2, authorComments2.size());
      Assertions.assertEquals(2, authorComments2.get("1")
            .size());
      Assertions.assertEquals(3, authorComments2.get("2")
            .size());
   }
}