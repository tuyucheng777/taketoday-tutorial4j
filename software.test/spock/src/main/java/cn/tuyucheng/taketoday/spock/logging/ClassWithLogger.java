package cn.tuyucheng.taketoday.spock.logging;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClassWithLogger {

   void logInfo() {
      LOGGER.info("info message");
   }

   void logInfoWithParameter(final String extraData) {
      LOGGER.info("info message: {}", extraData);
   }
}