package cn.tuyucheng.taketoday.logging.log4j2.xmlconfiguration;

import cn.tuyucheng.taketoday.logging.log4j2.Log4j2BaseIntegrationTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.plugins.util.PluginManager;
import org.junit.BeforeClass;
import org.junit.Test;

public class XMLConfigLogIntegrationTest extends Log4j2BaseIntegrationTest {

   @BeforeClass
   public static void setUp() {
      PluginManager.addPackage("cn.tuyucheng.taketoday.logging.log4j2.xmlconfiguration");
   }

   @Test
   public void givenXMLConfigurationPlugin_whenUsingFlowMarkers_ThenLogsCorrectly() throws Exception {
      Logger logger = LogManager.getLogger(this.getClass());
      Marker markerContent = MarkerManager.getMarker("FLOW");
      logger.debug(markerContent, "Debug log message");
      logger.info(markerContent, "Info log message");
      logger.error(markerContent, "Error log message");
   }

   @Test
   public void givenXMLConfigurationPlugin_whenSimpleLog_ThenLogsCorrectly() throws Exception {
      Logger logger = LogManager.getLogger(this.getClass());
      LoggerContext ctx = (LoggerContext) LogManager.getContext();
      logger.debug("Debug log message");
      logger.info("Info log message");
      logger.error("Error log message");
   }
}