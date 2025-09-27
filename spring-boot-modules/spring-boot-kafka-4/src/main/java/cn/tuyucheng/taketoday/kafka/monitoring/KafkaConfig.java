package cn.tuyucheng.taketoday.kafka.monitoring;

import io.micrometer.core.instrument.ImmutableTag;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ContainerProperties;

import java.util.Map;

import static java.util.Collections.singletonList;

@Configuration
class KafkaConfig {

   @Bean
   ConsumerFactory<String, String> consumerFactory(KafkaProperties kafkaProperties, MeterRegistry meterRegistry) {
      DefaultKafkaConsumerFactory<String, String> cf = new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties());
      cf.addListener(new MicrometerConsumerListener<>(meterRegistry, singletonList(new ImmutableTag("app-name", "article-comments-app"))));
      return cf;
   }

   @Bean
   ProducerFactory<String, ArticleCommentAddedEvent> producerFactory(KafkaProperties kafkaProperties, MeterRegistry meterRegistry) {
      ProducerFactory<String, ArticleCommentAddedEvent> pf = new DefaultKafkaProducerFactory<>(kafkaProperties.buildProducerProperties());
      pf.addListener(new MicrometerProducerListener<>(meterRegistry, singletonList(new ImmutableTag("app-name", "article-comments-app"))));
      return pf;
   }

   @Bean
   @Qualifier("articleCommentsKafkaTemplate")
   KafkaTemplate<String, ArticleCommentAddedEvent> articleCommentsKafkaTemplate(ProducerFactory<String, ArticleCommentAddedEvent> producerFactory) {
      var template = new KafkaTemplate<>(producerFactory);

      template.setObservationEnabled(true);
      template.setMicrometerTags(Map.of("topic", "tuyucheng.article-comment.added"));
      template.setMicrometerTagsProvider(record -> Map.of("article-slug", record.key()
            .toString()));

      return template;
   }

   @Bean
   ConcurrentKafkaListenerContainerFactory<String, String> customKafkaListenerContainerFactory(ConsumerFactory<String, String> consumerFactory) {
      ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
      factory.setConsumerFactory(consumerFactory);

      ContainerProperties containerProps = factory.getContainerProperties();
      containerProps.setObservationEnabled(true);
      containerProps.setMicrometerTags(Map.of("app-name", "article-comments-app"));
      containerProps.setMicrometerTagsProvider(record -> Map.of("article-slug", record.key()
            .toString()));

      return factory;
   }
}