package cn.tuyucheng.taketoday.junit5.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

class FieldSourceUnitTest {

   static List<String> cities = Arrays.asList("Madrid", "Rome", "Paris", "London");

   @ParameterizedTest
   @FieldSource("cities")
   void isBlank_ShouldReturnFalseWhenTheArgHasAtLEastOneCharacter(String arg) {
      assertFalse(Strings.isBlank(arg));
   }

   static String[] isEmpty_ShouldReturnFalseWhenTheArgHasAtLEastOneCharacter = {"Spain", "Italy", "France", "England"};

   @ParameterizedTest
   @FieldSource
   void isEmpty_ShouldReturnFalseWhenTheArgHasAtLEastOneCharacter(String arg) {
      assertFalse(arg.isEmpty());
   }
}