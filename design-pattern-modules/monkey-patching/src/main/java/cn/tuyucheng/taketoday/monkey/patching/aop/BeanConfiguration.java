package cn.tuyucheng.taketoday.monkey.patching.aop;

import cn.tuyucheng.taketoday.monkey.patching.converter.MoneyConverter;
import cn.tuyucheng.taketoday.monkey.patching.converter.MoneyConverterImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

   @Bean
   public MoneyConverter moneyConverter() {
      return new MoneyConverterImpl();
   }
}