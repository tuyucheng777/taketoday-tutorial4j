package cn.tuyucheng.taketoday.kafka.batch;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class KpiProducer {
   private final KafkaTemplate<String, String> kafkaTemplate;

   public KpiProducer(KafkaTemplate<String, String> kafkaTemplate) {
      this.kafkaTemplate = kafkaTemplate;
   }

   public void sendMessage(String topic, String message) throws ExecutionException, InterruptedException {
      kafkaTemplate.send(topic, message).get();
      this.kafkaTemplate.flush();
   }
}