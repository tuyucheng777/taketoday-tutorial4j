package cn.tuyucheng.taketoday.replaceremove;

import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringReplaceAndRemoveUnitTest {

   @Test
   public void givenTestStrings_whenReplace_thenProcessedString() {

      String master = "Hello World Tuyucheng!";
      String target = "Tuyucheng";
      String replacement = "Java";
      String processed = master.replace(target, replacement);
      assertTrue(processed.contains(replacement));
      assertFalse(processed.contains(target));

   }

   @Test
   public void givenTestStrings_whenReplaceAll_thenProcessedString() {

      String master2 = "Welcome to Tuyucheng, Hello World Tuyucheng";
      String regexTarget = "(Tuyucheng)$";
      String replacement = "Java";
      String processed2 = master2.replaceAll(regexTarget, replacement);
      assertTrue(processed2.endsWith("Java"));

   }

   @Test
   public void givenTestStrings_whenStringBuilderMethods_thenProcessedString() {

      String master = "Hello World Tuyucheng!";
      String target = "Tuyucheng";
      String replacement = "Java";

      int startIndex = master.indexOf(target);
      int stopIndex = startIndex + target.length();

      StringBuilder builder = new StringBuilder(master);

      builder.delete(startIndex, stopIndex);
      assertFalse(builder.toString()
            .contains(target));

      builder.replace(startIndex, stopIndex, replacement);
      assertTrue(builder.toString()
            .contains(replacement));

   }

   @Test
   public void givenTestStrings_whenStringUtilsMethods_thenProcessedStrings() {

      String master = "Hello World Tuyucheng!";
      String target = "Tuyucheng";
      String replacement = "Java";

      String processed = StringUtils.replace(master, target, replacement);
      assertTrue(processed.contains(replacement));

      String master2 = "Hello World Tuyucheng!";
      String target2 = "tuyucheng";
      String processed2 = StringUtils.replaceIgnoreCase(master2, target2, replacement);
      assertFalse(processed2.contains(target));

   }

   @Test
   public void givenTestStrings_whenReplaceExactWord_thenProcessedString() {
      String sentence = "A car is not the same as a carriage, and some planes can carry cars inside them!";
      String regexTarget = "\\bcar\\b";
      String exactWordReplaced = sentence.replaceAll(regexTarget, "truck");
      assertTrue("A truck is not the same as a carriage, and some planes can carry cars inside them!".equals(exactWordReplaced));
   }

   @Test
   public void givenTestStrings_whenReplaceExactWordUsingRegExUtilsMethod_thenProcessedString() {
      String sentence = "A car is not the same as a carriage, and some planes can carry cars inside them!";
      String regexTarget = "\\bcar\\b";
      String exactWordReplaced = RegExUtils.replaceAll(sentence, regexTarget, "truck");
      assertTrue("A truck is not the same as a carriage, and some planes can carry cars inside them!".equals(exactWordReplaced));
   }

}
