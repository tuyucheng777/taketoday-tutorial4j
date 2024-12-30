package cn.tuyucheng.taketoday.commons.lang3;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringUtilsUnitTest {
   @Test
   public void givenString_whenCheckingContainsAny_thenCorrect() {
      String string = "taketoday.com";
      boolean contained1 = StringUtils.containsAny(string, 'a', 'b', 'c');
      boolean contained2 = StringUtils.containsAny(string, 'x', 'y', 'z');
      boolean contained3 = StringUtils.containsAny(string, "abc");
      boolean contained4 = StringUtils.containsAny(string, "xyz");
      assertTrue(contained1);
      assertFalse(contained2);
      assertTrue(contained3);
      assertFalse(contained4);
   }

   @Test
   public void givenString_whenCheckingContainsIgnoreCase_thenCorrect() {
      String string = "taketoday.com";
      boolean contained = StringUtils.containsIgnoreCase(string, "BAELDUNG");
      assertTrue(contained);
   }

   @Test
   public void givenString_whenCountingMatches_thenCorrect() {
      String string = "welcome to www.taketoday.com";
      int charNum = StringUtils.countMatches(string, 'w');
      int stringNum = StringUtils.countMatches(string, "com");
      assertEquals(4, charNum);
      assertEquals(2, stringNum);
   }

   @Test
   public void givenString_whenAppendingAndPrependingIfMissing_thenCorrect() {
      String string = "taketoday.com";
      String stringWithSuffix = StringUtils.appendIfMissing(string, ".com");
      String stringWithPrefix = StringUtils.prependIfMissing(string, "www.");
      assertEquals("taketoday.com", stringWithSuffix);
      assertEquals("www.taketoday.com", stringWithPrefix);
   }

   @Test
   public void givenString_whenSwappingCase_thenCorrect() {
      String originalString = "taketoday.COM";
      String swappedString = StringUtils.swapCase(originalString);
      assertEquals("BAELDUNG.com", swappedString);
   }

   @Test
   public void givenString_whenCapitalizing_thenCorrect() {
      String originalString = "taketoday";
      String capitalizedString = StringUtils.capitalize(originalString);
      assertEquals("Taketoday", capitalizedString);
   }

   @Test
   public void givenString_whenUncapitalizing_thenCorrect() {
      String originalString = "Taketoday";
      String uncapitalizedString = StringUtils.uncapitalize(originalString);
      assertEquals("taketoday", uncapitalizedString);
   }

   @Test
   public void givenString_whenReversingCharacters_thenCorrect() {
      String originalString = "taketoday";
      String reversedString = StringUtils.reverse(originalString);
      assertEquals("gnudleab", reversedString);
   }

   @Test
   public void givenString_whenReversingWithDelimiter_thenCorrect() {
      String originalString = "www.taketoday.com";
      String reversedString = StringUtils.reverseDelimited(originalString, '.');
      assertEquals("cn.tuyucheng.taketoday.www", reversedString);
   }

   @Test
   public void givenString_whenRotatingTwoPositions_thenCorrect() {
      String originalString = "taketoday";
      String rotatedString = StringUtils.rotate(originalString, 4);
      assertEquals("dungbael", rotatedString);
   }

   @Test
   public void givenTwoStrings_whenComparing_thenCorrect() {
      String tutorials = "Taketoday Tutorials";
      String courses = "Taketoday Courses";
      String diff1 = StringUtils.difference(tutorials, courses);
      String diff2 = StringUtils.difference(courses, tutorials);
      assertEquals("Courses", diff1);
      assertEquals("Tutorials", diff2);
   }
}