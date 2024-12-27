package cn.tuyucheng.taketoday.camel.boot.exception;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ExceptionLoggingProcessor implements Processor {

   private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionLoggingProcessor.class);

   @Override
   public void process(Exchange exchange) throws Exception {
      Map<String, Object> headersMap = exchange.getIn().getHeaders();

      if (!headersMap.isEmpty()) {
         headersMap.forEach((key, value) -> LOGGER.info("Header key [{}] -||- Header value [{}]", key, value));
      } else {
         LOGGER.info("Empty header");
      }
   }
}