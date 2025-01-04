package cn.tuyucheng.taketoday.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VariableFetchSizeKafkaListener implements Runnable {
   private static Logger log = LoggerFactory.getLogger(VariableFetchSizeKafkaListener.class);
   private final String topic;
   private final KafkaConsumer<String, String> consumer;

   public VariableFetchSizeKafkaListener(String topic, KafkaConsumer<String, String> consumer) {
      this.topic = topic;
      this.consumer = consumer;
   }

   @Override
   public void run() {
      consumer.subscribe(Collections.singletonList(topic));
      int pollCount = 1;

      while (true) {
         List<ConsumerRecord<String, String>> records = new ArrayList<>();
         for (ConsumerRecord<String, String> record : consumer.poll(Duration.ofMillis(500))) {
            records.add(record);
         }
         if (!records.isEmpty()) {
            String batchOffsets = String.format("%s -> %s", records.get(0).offset(), records.get(records.size() - 1).offset());
            String groupId = consumer.groupMetadata().groupId();
            log.info("groupId: {}, poll: #{}, fetched: #{} records, offsets: {}", groupId, pollCount++, records.size(), batchOffsets);
         }
      }
   }
}