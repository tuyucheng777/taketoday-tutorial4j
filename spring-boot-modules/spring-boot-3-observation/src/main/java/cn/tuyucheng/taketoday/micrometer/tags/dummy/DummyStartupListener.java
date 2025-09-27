package cn.tuyucheng.taketoday.micrometer.tags.dummy;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
class DummyStartupListener {

   private static final List<String> deviceTypes = List.of("desktop", "mobile", "tablet", "smart_tv", "wearable");

   private final DummyService service;

   @EventListener(ApplicationReadyEvent.class)
   void sendRequests() {
      IntStream.range(0, 100)
            .map(it -> it % deviceTypes.size())
            .mapToObj(deviceTypes::get)
            .parallel()
            .forEach(deviceType -> {
               service.foo(deviceType);
               service.bar(deviceType);
               service.buzz(deviceType);
            });
   }

   DummyStartupListener(DummyService service) {
      this.service = service;
   }
}