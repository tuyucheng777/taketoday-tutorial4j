package cn.tuyucheng.taketoday.systemrules;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemErr;

class SystemErrPrintlnUnitTest {

   @Test
   void givenTapSystemErr_whenInvokePrintln_thenOutputIsReturnedSuccessfully() throws Exception {

      String text = tapSystemErr(() -> {
         printError("An error occurred Baeldung Readers!!");
      });

      Assert.assertEquals("An error occurred Baeldung Readers!!", text.trim());
   }

   private void printError(String output) {
      System.err.println(output);
   }
}