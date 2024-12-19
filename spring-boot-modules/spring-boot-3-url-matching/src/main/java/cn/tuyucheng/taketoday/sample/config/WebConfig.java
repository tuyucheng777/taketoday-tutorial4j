package cn.tuyucheng.taketoday.sample.config;

import cn.tuyucheng.taketoday.sample.filters.TrailingSlashRedirectFilter;
import cn.tuyucheng.taketoday.sample.filters.TrailingSlashRedirectFilterReactive;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.filter.UrlHandlerFilter;
import org.springframework.web.server.WebFilter;

import static org.springframework.http.HttpStatus.PERMANENT_REDIRECT;

@Configuration
public class WebConfig {

   @Bean
   public WebFilter trailingSlashRedirectReactiveFilter() {
      return new TrailingSlashRedirectFilterReactive();
   }

   @Bean
   public Filter trailingSlashRedirectFilter() {
      return new TrailingSlashRedirectFilter();
   }

   @Bean
   public FilterRegistrationBean<Filter> trailingSlashFilter() {
      FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
      registrationBean.setFilter(trailingSlashRedirectFilter());
      registrationBean.addUrlPatterns("/*");
      return registrationBean;
   }

   @Bean
   public FilterRegistrationBean<OncePerRequestFilter> urlHandlerFilterRegistrationBean() {
      FilterRegistrationBean<OncePerRequestFilter> registrationBean = new FilterRegistrationBean<>();
      UrlHandlerFilter urlHandlerFilter = UrlHandlerFilter
            .trailingSlashHandler("/blog/**").redirect(PERMANENT_REDIRECT)
            .trailingSlashHandler("/greetings/**").wrapRequest()
            .build();

      registrationBean.setFilter(urlHandlerFilter);

      return registrationBean;
   }
}