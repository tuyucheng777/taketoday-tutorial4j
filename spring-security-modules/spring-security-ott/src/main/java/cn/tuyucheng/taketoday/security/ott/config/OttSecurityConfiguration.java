package cn.tuyucheng.taketoday.security.ott.config;

import cn.tuyucheng.taketoday.security.ott.service.OttSenderService;
import cn.tuyucheng.taketoday.security.ott.service.FakeOttSenderService;
import cn.tuyucheng.taketoday.security.ott.web.OttLoginLinkSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.ott.OneTimeTokenGenerationSuccessHandler;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class OttSecurityConfiguration {

   @Bean
   SecurityFilterChain ottSecurityFilterChain(HttpSecurity http) throws Exception {
      return http
            .authorizeHttpRequests(ht ->
                  ht.anyRequest().authenticated())
            .formLogin(withDefaults())
            .oneTimeTokenLogin(withDefaults())
            .build();
   }

   @Bean
   OneTimeTokenGenerationSuccessHandler ottSuccessHandler(OttSenderService ottSenderService) {
      return new OttLoginLinkSuccessHandler(ottSenderService);
   }

   @Bean
   OttSenderService ottSenderService() {
      return new FakeOttSenderService();
   }
}