package cn.tuyucheng.taketoday.junit5.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RepeatableArgumentSourceAnnotationsUnitTest {

   static List<String> asia() {
      return Arrays.asList("Japan", "India", "Thailand");
   }

   static List<String> europe() {
      return Arrays.asList("Spain", "Italy", "England");
   }

   @ParameterizedTest
   @MethodSource("asia")
   @MethodSource("europe")
   void whenStringIsLargerThanThreeCharacters_thenReturnTrue(String country) {
      assertTrue(country.length() > 3);
   }
}