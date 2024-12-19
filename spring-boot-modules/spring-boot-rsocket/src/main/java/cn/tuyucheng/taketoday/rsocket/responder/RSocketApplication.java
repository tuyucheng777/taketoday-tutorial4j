package cn.tuyucheng.taketoday.rsocket.responder;

import cn.tuyucheng.taketoday.rsocket.requester.MessageClient;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.service.RSocketServiceProxyFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class RSocketApplication {
   public static void main(String[] args) {
      SpringApplication.run(RSocketApplication.class, args);
   }

   @Bean
   public RSocketServiceProxyFactory getRSocketServiceProxyFactory(RSocketRequester.Builder requestBuilder) {
      RSocketRequester requester = requestBuilder.tcp("localhost", 7000);
      return RSocketServiceProxyFactory.builder(requester)
            .build();
   }

   @Bean
   public MessageClient getClient(RSocketServiceProxyFactory factory) {
      return factory.createClient(MessageClient.class);
   }

   @Bean
   public ApplicationRunner runRequestResponseModel(MessageClient client) {
      return _ -> client.sendMessage(Mono.just("Request-Response test "))
            .doOnNext(message -> System.out.println("Response is :" + message))
            .subscribe();
   }

   @Bean
   public ApplicationRunner runStreamModel(MessageClient client) {
      return _ -> client.Counter()
            .doOnNext(t -> System.out.println("message is :" + t))
            .subscribe();
   }

   @Bean
   public ApplicationRunner runFireAndForget(MessageClient client) {
      return _ -> client.Warning(Mono.just("Important Warning"))
            .subscribe();
   }

   @Bean
   public ApplicationRunner runChannel(MessageClient client) {
      return _ -> client.channel(Flux.just("a", "b", "c", "d", "e"))
            .doOnNext(System.out::println)
            .subscribe();
   }
}