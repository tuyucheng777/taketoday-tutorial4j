package cn.tuyucheng.taketoday.systemrules;

import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.catchSystemExit;
import static org.junit.Assert.assertEquals;

class SystemExitUnitTest {

   @Test
   void givenCatchSystemExit_whenAppCallsSystemExit_thenStatusIsReturnedSuccessfully() throws Exception {
      int statusCode = catchSystemExit(() -> {
         exit();
      });
      assertEquals("status code should be 1:", 1, statusCode);
   }

   private void exit() {
      System.exit(1);
   }
}