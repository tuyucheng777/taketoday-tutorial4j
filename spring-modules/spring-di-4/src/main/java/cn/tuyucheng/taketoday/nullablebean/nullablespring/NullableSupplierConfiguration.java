package cn.tuyucheng.taketoday.nullablebean.nullablespring;

import cn.tuyucheng.taketoday.nullablebean.MainComponent;
import cn.tuyucheng.taketoday.nullablebean.SubComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Supplier;

@Configuration
public class NullableSupplierConfiguration {

   @Bean
   public MainComponent mainComponent(Supplier<SubComponent> subComponentSupplier) {
      return new MainComponent(subComponentSupplier.get());
   }

   @Bean
   public Supplier<SubComponent> subComponentSupplier() {
      return () -> null;
   }
}