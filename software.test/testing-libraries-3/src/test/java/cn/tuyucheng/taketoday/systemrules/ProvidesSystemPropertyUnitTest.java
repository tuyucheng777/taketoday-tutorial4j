package cn.tuyucheng.taketoday.systemrules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.restoreSystemProperties;

class ProvidesSystemPropertyUnitTest {

   @BeforeAll
   static void setUpBeforeClass() throws Exception {
      System.setProperty("log_dir", "/tmp/baeldung/logs");
   }

   @Test
   void givenSetSystemProperty_whenGetLogDir_thenLogDirIsProvidedSuccessfully() throws Exception {
      restoreSystemProperties(() -> {
         System.setProperty("log_dir", "test/resources");
         Assertions.assertEquals("test/resources", System.getProperty("log_dir"), "log_dir should be provided");
      });

      Assertions.assertEquals("/tmp/baeldung/logs", System.getProperty("log_dir"), "log_dir should be provided");
   }
}