package cn.tuyucheng.taketoday.kafka.retryable;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.AcknowledgingConsumerAwareMessageListener;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.ActiveProfiles;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = RetryableApplicationKafkaApp.class)
@EmbeddedKafka(partitions = 1, controlledShutdown = true, brokerProperties = {"listeners=PLAINTEXT://localhost:9093", "port=9093"})
@ActiveProfiles("retry")
public class KafkaRetryableIntegrationTest {

   @Autowired
   private KafkaListenerEndpointRegistry registry;

   @Autowired
   private KafkaTemplate<String, String> template;

   private ObjectMapper objectMapper = new ObjectMapper();

   private static final String CONTAINER_GROUP = "multiGroup";

   private static final String TOPIC = "topic";

   @BeforeEach
   public void setup() {
      System.setProperty("spring.kafka.bootstrap-servers", "localhost:9093");
   }

   @Test
   public void givenEmbeddedKafkaBroker_whenSendingAWellFormedMessage_thenMessageIsConsumed() throws Exception {
      ConcurrentMessageListenerContainer<?, ?> container = (ConcurrentMessageListenerContainer<?, ?>) registry.getListenerContainer(CONTAINER_GROUP);
      container.stop();
      @SuppressWarnings("unchecked") AcknowledgingConsumerAwareMessageListener<String, String> messageListener = (AcknowledgingConsumerAwareMessageListener<String, String>) container.getContainerProperties()
            .getMessageListener();
      CountDownLatch latch = new CountDownLatch(1);
      container.getContainerProperties()
            .setMessageListener((AcknowledgingConsumerAwareMessageListener<String, String>) (data, acknowledgment, consumer) -> {
               messageListener.onMessage(data, acknowledgment, consumer);
               latch.countDown();
            });
      Greeting greeting = new Greeting("test1", "test2");
      container.start();
      template.send(TOPIC, objectMapper.writeValueAsString(greeting));
      assertThat(latch.await(10, TimeUnit.SECONDS)).isFalse();
   }

   @Test
   public void givenEmbeddedKafkaBroker_whenSendingAMalFormedMessage_thenMessageIsConsumedAfterRetry() throws Exception {
      ConcurrentMessageListenerContainer<?, ?> container = (ConcurrentMessageListenerContainer<?, ?>) registry.getListenerContainer(CONTAINER_GROUP);
      container.stop();
      @SuppressWarnings("unchecked") AcknowledgingConsumerAwareMessageListener<String, String> messageListener = (AcknowledgingConsumerAwareMessageListener<String, String>) container.getContainerProperties()
            .getMessageListener();
      CountDownLatch latch = new CountDownLatch(1);
      container.getContainerProperties()
            .setMessageListener((AcknowledgingConsumerAwareMessageListener<String, String>) (data, acknowledgment, consumer) -> {
               messageListener.onMessage(data, acknowledgment, consumer);
               latch.countDown();
            });
      container.start();
      Greeting greeting = new Greeting("test", "test");
      template.send(TOPIC, objectMapper.writeValueAsString(greeting));
      // this message will go on error
      Greeting greeting2 = new Greeting("test2", "test2");
      template.send(TOPIC, objectMapper.writeValueAsString(greeting2));
      assertThat(latch.getCount()).isEqualTo(1);
   }
}