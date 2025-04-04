package cn.tuyucheng.taketoday.consumer;

import cn.tuyucheng.taketoday.schema.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.stereotype.Service;

@Service
public class AvroConsumer {

   private static final Logger LOGGER = LoggerFactory.getLogger(AvroConsumer.class);

   @StreamListener(Processor.INPUT)
   public void consumeEmployeeDetails(Employee employeeDetails) {
      LOGGER.info("Let's process employee details: {}", employeeDetails);
   }
}