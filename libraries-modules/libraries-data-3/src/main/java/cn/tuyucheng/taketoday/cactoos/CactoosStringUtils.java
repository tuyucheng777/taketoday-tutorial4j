package cn.tuyucheng.taketoday.cactoos;

import org.cactoos.text.*;

public class CactoosStringUtils {

   public String createString() throws Exception {
      String testString = new TextOf("Test String").asString();
      return testString;
   }

   public String createdFormattedString(String stringToFormat) throws Exception {
      String formattedString = new FormattedText("Hello %s", stringToFormat).asString();
      return formattedString;
   }

   public String toLowerCase(String testString) throws Exception {
      String lowerCaseString = new Lowered(new TextOf(testString)).asString();
      return lowerCaseString;
   }

   public String toUpperCase(String testString) throws Exception {
      String upperCaseString = new Upper(new TextOf(testString)).asString();
      return upperCaseString;
   }

   public boolean isBlank(String testString) throws Exception {
      return new IsBlank(new TextOf(testString)) != null;
   }
}