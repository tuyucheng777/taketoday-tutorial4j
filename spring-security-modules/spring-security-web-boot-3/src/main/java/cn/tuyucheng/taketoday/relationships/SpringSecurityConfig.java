package cn.tuyucheng.taketoday.relationships;

import cn.tuyucheng.taketoday.relationships.security.AuthenticationSuccessHandlerImpl;
import cn.tuyucheng.taketoday.relationships.security.CustomUserDetailsService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.context.WebApplicationContext;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@ComponentScan("cn.tuyucheng.taketoday.security")
public class SpringSecurityConfig {

   @Autowired
   private WebApplicationContext applicationContext;

   @Autowired
   private AuthenticationSuccessHandlerImpl successHandler;

   @Autowired
   private DataSource dataSource;

   private CustomUserDetailsService userDetailsService;

   @PostConstruct
   public void completeSetup() {
      userDetailsService = applicationContext.getBean(CustomUserDetailsService.class);
   }

   @Bean
   public UserDetailsManager users(HttpSecurity http) throws Exception {
      AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
      authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(encoder());
      authenticationManagerBuilder.authenticationProvider(authenticationProvider());
      AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

      JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
      jdbcUserDetailsManager.setAuthenticationManager(authenticationManager);
      return jdbcUserDetailsManager;
   }

   @Bean
   public WebSecurityCustomizer webSecurityCustomizer() {
      return web -> web.ignoring().requestMatchers("/resources/**");
   }

   @Bean
   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
                  authorizationManagerRequestMatcherRegistry.requestMatchers("/login").permitAll())
            .formLogin(httpSecurityFormLoginConfigurer ->
                  httpSecurityFormLoginConfigurer.permitAll().successHandler(successHandler))
            .csrf(AbstractHttpConfigurer::disable);
      return http.build();
   }

   @Bean
   public DaoAuthenticationProvider authenticationProvider() {
      final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
      authProvider.setUserDetailsService(userDetailsService);
      authProvider.setPasswordEncoder(encoder());
      return authProvider;
   }

   @Bean
   public PasswordEncoder encoder() {
      return new BCryptPasswordEncoder(11);
   }

   @Bean
   public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
      return new SecurityEvaluationContextExtension();
   }
}