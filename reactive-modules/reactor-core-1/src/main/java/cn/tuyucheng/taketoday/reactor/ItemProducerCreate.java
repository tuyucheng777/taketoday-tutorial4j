package cn.tuyucheng.taketoday.reactor;

import reactor.core.publisher.Flux;

import java.util.List;
import java.util.function.Consumer;

public class ItemProducerCreate {

   Consumer<List<String>> listener;

   public Flux<String> create() {
      return Flux.create((sink) -> this.listener = (items) -> items
            .forEach(sink::next));
   }
}