package cn.tuyucheng.taketoday.kafka.testcontainers;

import cn.tuyucheng.taketoday.kafka.embedded.KafkaConsumer;
import cn.tuyucheng.taketoday.kafka.embedded.KafkaProducer;
import cn.tuyucheng.taketoday.kafka.embedded.KafkaProducerConsumerApplication;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This test class uses Testcontainers to instantiate and manage an external Apache
 * Kafka broker hosted inside a Docker container.
 * <p>
 * Therefore, one of the prerequisites for using Testcontainers is that Docker is installed on the host running this test
 */
@RunWith(SpringRunner.class)
@Import(cn.tuyucheng.taketoday.kafka.testcontainers.KafkaTestContainersLiveTest.KafkaTestContainersConfiguration.class)
@SpringBootTest(classes = KafkaProducerConsumerApplication.class)
@DirtiesContext
public class KafkaTestContainersLiveTest {

   @ClassRule
   public static KafkaContainer kafka = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:5.4.3"));

   @Autowired
   public KafkaTemplate<String, String> template;

   @Autowired
   private KafkaConsumer consumer;

   @Autowired
   private KafkaProducer producer;

   @Value("${test.topic}")
   private String topic;

   @Before
   public void setup() {
      consumer.resetLatch();
   }

   @Test
   public void givenKafkaDockerContainer_whenSendingWithDefaultTemplate_thenMessageReceived() throws Exception {
      String data = "Sending with default template";

      template.send(topic, data);

      boolean messageConsumed = consumer.getLatch().await(10, TimeUnit.SECONDS);
      assertTrue(messageConsumed);
      assertThat(consumer.getPayload(), containsString(data));
   }

   @Test
   public void givenKafkaDockerContainer_whenSendingWithSimpleProducer_thenMessageReceived() throws Exception {
      String data = "Sending with our own simple KafkaProducer";

      producer.send(topic, data);

      boolean messageConsumed = consumer.getLatch().await(10, TimeUnit.SECONDS);
      assertTrue(messageConsumed);
      assertThat(consumer.getPayload(), containsString(data));
   }

   @TestConfiguration
   static class KafkaTestContainersConfiguration {

      @Bean
      ConcurrentKafkaListenerContainerFactory<Integer, String> kafkaListenerContainerFactory() {
         ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
         factory.setConsumerFactory(consumerFactory());
         return factory;
      }

      @Bean
      public ConsumerFactory<Integer, String> consumerFactory() {
         return new DefaultKafkaConsumerFactory<>(consumerConfigs());
      }

      @Bean
      public Map<String, Object> consumerConfigs() {
         Map<String, Object> props = new HashMap<>();
         props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafka.getBootstrapServers());
         props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
         props.put(ConsumerConfig.GROUP_ID_CONFIG, "taketoday");
         props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
         props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
         return props;
      }

      @Bean
      public ProducerFactory<String, String> producerFactory() {
         Map<String, Object> configProps = new HashMap<>();
         configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafka.getBootstrapServers());
         configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
         configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
         return new DefaultKafkaProducerFactory<>(configProps);
      }

      @Bean
      public KafkaTemplate<String, String> kafkaTemplate() {
         return new KafkaTemplate<>(producerFactory());
      }
   }
}