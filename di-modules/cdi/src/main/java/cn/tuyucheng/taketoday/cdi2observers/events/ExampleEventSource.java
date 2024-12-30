package cn.tuyucheng.taketoday.cdi2observers.events;

import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

public class ExampleEventSource {

   @Inject
   Event<ExampleEvent> exampleEvent;

   public void fireEvent() {
      exampleEvent.fireAsync(new ExampleEvent("Welcome to Taketoday!"));
   }
}