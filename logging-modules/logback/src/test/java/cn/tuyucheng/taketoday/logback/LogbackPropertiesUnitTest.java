package cn.tuyucheng.taketoday.logback;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogbackPropertiesUnitTest {

   private static LoggerContext loggerContext;

   @BeforeAll
   public static void setUp() {
      System.setProperty("logback.configurationFile", "src/test/resources/logback-properties.xml");
      loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
   }

   @Test
   public void whenUserPropertiesFile_thenReturnCorrectLevel() {
      Logger rootLogger = loggerContext.getLogger(Logger.ROOT_LOGGER_NAME);
      assertEquals(Level.INFO, rootLogger.getLevel());

      Logger taketodayLogger = loggerContext.getLogger("cn.tuyucheng.taketoday.logback");
      assertEquals(Level.DEBUG, taketodayLogger.getLevel());

      Logger taketodayServicesLogger = loggerContext.getLogger("cn.tuyucheng.taketoday.logback.services");
      assertEquals(Level.ERROR, taketodayServicesLogger.getLevel());
   }
}