package cn.tuyucheng.taketoday.kafka.commitoffset;

import cn.tuyucheng.taketoday.kafka.commitoffset.config.KafkaConfigProperties;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Properties;

public class AutomaticCommit {

   public static void main(String[] args) {

      Properties properties = KafkaConfigProperties.getProperties();
      properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
      KafkaConsumer<Long, String> consumer = new KafkaConsumer<>(properties);
      consumer.subscribe(KafkaConfigProperties.getTopic());
      ConsumerRecords<Long, String> messages = consumer.poll(Duration.ofSeconds(10));
      for (ConsumerRecord<Long, String> _ : messages) {
         // processed message
      }
   }
}