package cn.tuyucheng.taketoday.spring.zipwhen.service;

import cn.tuyucheng.taketoday.spring.zipwhen.model.User;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DatabaseService {
   private Map<String, User> dataStore = new ConcurrentHashMap<>();

   public Mono<Boolean> saveUserData(User user) {
      return Mono.create(sink -> {
         try {
            dataStore.put(user.getId(), user);
            sink.success(true);
         } catch (Exception e) {
            sink.success(false);
         }
      });
   }
}