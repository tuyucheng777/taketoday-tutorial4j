package cn.tuyucheng.taketoday.activitiwithspring;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ProcessEngineCreationIntegrationTest {

   @Test
   void givenXMLConfig_whenGetDefault_thenGotProcessEngine() {
      ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
      assertNotNull(processEngine);
      assertEquals("root", processEngine.getProcessEngineConfiguration().getJdbcUsername());
   }

   @Test
   void givenXMLConfig_whenCreateDefaultConfiguration_thenGotProcessEngine() {
      ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();
      ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
      assertNotNull(processEngine);
      assertEquals("root", processEngine.getProcessEngineConfiguration().getJdbcUsername());
   }

   @Test
   void givenDifferentNameXMLConfig_whenGetProcessEngineConfig_thenGotResult() {
      ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("my.activiti.cfg.xml");
      ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
      assertNotNull(processEngine);
      assertEquals("tuyucheng", processEngine.getProcessEngineConfiguration().getJdbcUsername());
   }

   @Test
   void givenDifferentBeanNameInXMLConfig_whenGetProcessEngineConfig_thenGotResult() {
      ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration
            .createProcessEngineConfigurationFromResource("my.activiti.cfg.xml", "myProcessEngineConfiguration");
      ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
      assertNotNull(processEngine);
      assertEquals("tuyucheng", processEngine.getProcessEngineConfiguration().getJdbcUsername());
   }

   @Test
   void givenNoXMLConfig_whenCreateInMemProcessEngineConfig_thenCreated() {
      ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createStandaloneInMemProcessEngineConfiguration();
      ProcessEngine processEngine = processEngineConfiguration
            .setJdbcUrl("jdbc:h2:mem:my-own-in-mem-db;DB_CLOSE_DELAY=1000")
            .buildProcessEngine();
      assertNotNull(processEngine);
      assertEquals("sa", processEngine.getProcessEngineConfiguration().getJdbcUsername());
   }

   @Test
   void givenNoXMLConfig_whenCreateProcessEngineConfig_thenCreated() {
      ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
      ProcessEngine processEngine = processEngineConfiguration
            .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)
            .setJdbcUrl("jdbc:h2:mem:my-own-db;DB_CLOSE_DELAY=1000")
            .buildProcessEngine();
      assertNotNull(processEngine);
      assertEquals("sa", processEngine.getProcessEngineConfiguration().getJdbcUsername());
   }

   @AfterEach
   void cleanup() {
      ProcessEngines.destroy();
   }
}