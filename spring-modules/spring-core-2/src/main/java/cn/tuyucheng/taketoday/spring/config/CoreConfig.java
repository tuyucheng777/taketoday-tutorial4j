package cn.tuyucheng.taketoday.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
@ComponentScan("cn.tuyucheng.taketoday.core")
public class CoreConfig implements WebMvcConfigurer {

   public CoreConfig() {
      super();
   }

   @Bean
   public ExecutorService setupExecutor() {
      final int coreThreads = 4;
      final int maxThreads = 8;
      final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(coreThreads, maxThreads, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
      threadPoolExecutor.allowCoreThreadTimeOut(true);
      return threadPoolExecutor;
   }
}