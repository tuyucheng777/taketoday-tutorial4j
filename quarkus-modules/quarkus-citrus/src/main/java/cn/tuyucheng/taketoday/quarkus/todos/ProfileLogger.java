package cn.tuyucheng.taketoday.quarkus.todos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

import io.quarkus.runtime.StartupEvent;
import io.quarkus.runtime.configuration.ConfigUtils;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class ProfileLogger {

   void onStart(@Observes StartupEvent ev) {
      LOGGER.info("The application is starting with profile {}", ConfigUtils.getProfiles());
   }
}