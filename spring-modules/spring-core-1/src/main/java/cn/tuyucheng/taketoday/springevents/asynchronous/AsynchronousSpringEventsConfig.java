package cn.tuyucheng.taketoday.springevents.asynchronous;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@Configuration
@ComponentScan("cn.tuyucheng.taketoday.springevents.synchronous")
public class AsynchronousSpringEventsConfig {

   @Bean(name = "applicationEventMulticaster")
   public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
      final SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = new SimpleApplicationEventMulticaster();
      simpleApplicationEventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
      return simpleApplicationEventMulticaster;
   }
}