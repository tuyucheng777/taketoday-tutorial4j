package cn.tuyucheng.taketoday;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtelConfiguration {
   @Bean
   public OpenTelemetry openTelemetry() {
      return GlobalOpenTelemetry.get();
   }
}