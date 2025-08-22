package cn.tuyucheng.taketoday.eventuate.tram;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import io.eventuate.tram.spring.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.spring.messaging.producer.jdbc.TramMessageProducerJdbcConfiguration;

@Configuration
@Import({TramEventsPublisherConfiguration.class, TramMessageProducerJdbcConfiguration.class})
class EventuateConfig {
}