package cn.tuyucheng.taketoday.boot.config;

import cn.tuyucheng.taketoday.boot.services.IBarService;
import cn.tuyucheng.taketoday.boot.services.impl.BarSpringDataJpaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Profile("!tc")
@EnableTransactionManagement
@EnableJpaAuditing
public class PersistenceConfiguration {

   @Bean
   public IBarService barSpringDataJpaService() {
      return new BarSpringDataJpaService();
   }
}