package cn.tuyucheng.taketoday.petstore.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.tuyucheng.taketoday.petstore.client.api.PetApi;
import cn.tuyucheng.taketoday.petstore.client.invoker.ApiClient;

@Configuration
public class PetStoreIntegrationConfig {

   @Bean
   public PetApi petpi() {
      return new PetApi(apiClient());
   }

   @Bean
   public ApiClient apiClient() {
      return new ApiClient();
   }
}