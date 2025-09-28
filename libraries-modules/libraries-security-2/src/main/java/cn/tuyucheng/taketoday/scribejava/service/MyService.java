package cn.tuyucheng.taketoday.scribejava.service;

import cn.tuyucheng.taketoday.scribejava.api.MyApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class MyService {

   private OAuth20Service service;
   private final String API_KEY = "tuyucheng_api_key";
   private final String API_SECRET = "tuyucheng_api_secret";

   @PostConstruct
   private void init() {
      this.service = new ServiceBuilder(API_KEY)
            .apiSecret(API_SECRET)
            .defaultScope("read write")
            .build(MyApi.instance());
   }


   public OAuth20Service getService() {
      return service;
   }
}