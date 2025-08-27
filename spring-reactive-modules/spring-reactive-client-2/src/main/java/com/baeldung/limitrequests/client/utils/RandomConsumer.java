package cn.tuyucheng.taketoday.limitrequests.client.utils;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;

import cn.tuyucheng.taketoday.limitrequests.server.RandomController;

import reactor.core.publisher.Mono;

public interface RandomConsumer {

   static <T> Mono<T> get(WebClient client, String id) {
      return client.get()
            .header(RandomController.CLIENT_ID_HEADER, id)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<T>() {
            });
   }
}
