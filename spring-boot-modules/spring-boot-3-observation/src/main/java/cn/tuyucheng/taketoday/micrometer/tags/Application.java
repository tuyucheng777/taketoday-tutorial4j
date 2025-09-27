package cn.tuyucheng.taketoday.micrometer.tags;

import io.micrometer.core.aop.CountedAspect;
import io.micrometer.core.aop.CountedMeterTagAnnotationHandler;
import io.micrometer.core.aop.MeterTagAnnotationHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
class Application {

   public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
   }

   @Bean
   public MeterTagAnnotationHandler meterTagAnnotationHandler() {
      return new MeterTagAnnotationHandler(
            _ -> Object::toString,
            _ -> (_, _) -> "");
   }

   @Bean
   public CountedAspect countedAspect() {
      CountedAspect aspect = new CountedAspect();
      CountedMeterTagAnnotationHandler tagAnnotationHandler = new CountedMeterTagAnnotationHandler(
            _ -> Object::toString,
            _ -> (_, _) -> "");
      aspect.setMeterTagAnnotationHandler(tagAnnotationHandler);
      return aspect;
   }
}