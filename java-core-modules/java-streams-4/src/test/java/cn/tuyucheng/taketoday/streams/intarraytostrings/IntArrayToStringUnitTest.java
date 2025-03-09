package cn.tuyucheng.taketoday.streams.intarraytostrings;

import org.junit.Assert;
import org.junit.Test;

import static cn.tuyucheng.taketoday.streams.intarraytostrings.ArrayConversionUtils.*;

public class IntArrayToStringUnitTest {

   @Test
   public void whenConvertingIntegers_thenHandleStreamOfIntegers() {
      Integer[] integerNumbers = {1, 2, 3, 4, 5};
      String[] expectedOutput = {"1", "2", "3", "4", "5"};

      String[] strings = convertToStringArray(integerNumbers);

      Assert.assertArrayEquals(expectedOutput, strings);
   }

   @Test
   public void whenConvertingInts_thenHandleIntStream() {
      int[] intNumbers = {1, 2, 3, 4, 5};
      String[] expectedOutput = {"1", "2", "3", "4", "5"};

      String[] strings = convertToStringArray(intNumbers);

      Assert.assertArrayEquals(expectedOutput, strings);
   }

   @Test
   public void givenAnIntArray_whenBoxingToInteger_thenHandleStreamOfIntegers() {
      int[] intNumbers = {1, 2, 3, 4, 5};
      String[] expectedOutput = {"1", "2", "3", "4", "5"};

      String[] strings = convertToStringArrayWithBoxing(intNumbers);

      Assert.assertArrayEquals(expectedOutput, strings);
   }

   @Test
   public void givenAnIntArray_whenUsingCollectorsJoining_thenReturnCommaSeparatedString() {
      int[] intNumbers = {1, 2, 3, 4, 5};
      String expectedOutput = "1, 2, 3, 4, 5";

      String string = convertToString(intNumbers);

      Assert.assertEquals(expectedOutput, string);
   }
}