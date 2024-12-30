package cn.tuyucheng.taketoday.cactoos;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CactoosStringUtilsUnitTest {

   @Test
   public void whenFormattedTextIsPassedWithArgs_thenFormattedStringIsReturned() throws Exception {
      CactoosStringUtils obj = new CactoosStringUtils();

      // when
      String formattedString = obj.createdFormattedString("John");

      // then
      assertEquals("Hello John", formattedString);
   }

   @Test
   public void whenStringIsPassesdToLoweredOrUpperClass_thenCorrespondingStringIsReturned() throws Exception {
      CactoosStringUtils obj = new CactoosStringUtils();

      // when
      String lowerCaseString = obj.toLowerCase("TeSt StrIng");
      String upperCaseString = obj.toUpperCase("TeSt StrIng");

      // then
      assertEquals("test string", lowerCaseString);
      assertEquals("TEST STRING", upperCaseString);
   }

   @Test
   public void whenEmptyStringIsPassesd_thenIsBlankReturnsTrue() throws Exception {
      CactoosStringUtils obj = new CactoosStringUtils();

      // when
      boolean isBlankEmptyString = obj.isBlank("");
      boolean isBlankNull = obj.isBlank(null);

      // then
      assertTrue(isBlankEmptyString);
      assertTrue(isBlankNull);
   }
}