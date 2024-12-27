package cn.tuyucheng.taketoday.consumerackspubconfirms;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class SimpleUuidConsumer {

   private static final Logger log = LoggerFactory.getLogger(SimpleUuidConsumer.class);

   private final Channel channel;
   private final String queue;

   public SimpleUuidConsumer(Channel channel, String queue) {
      this.channel = channel;
      this.queue = queue;
   }

   public void consume() throws IOException {
      log.debug("starting consumer");

      channel.basicConsume(queue, true, (_, delivery) -> {
         String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
         long deliveryTag = delivery.getEnvelope()
               .getDeliveryTag();

         process(message, deliveryTag);
      }, cancelledTag -> {
         log.warn("cancelled: #{}", cancelledTag);
      });
   }

   private void process(String message, long deliveryTag) {
      try {
         UUID.fromString(message);
         log.debug("* [#{}] processed: {}", deliveryTag, message);
      } catch (IllegalArgumentException e) {
         log.warn("* [#{}] invalid: {}", deliveryTag, message);
      }
   }
}