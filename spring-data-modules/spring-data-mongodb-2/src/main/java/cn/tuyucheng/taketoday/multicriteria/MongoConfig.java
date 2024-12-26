package cn.tuyucheng.taketoday.multicriteria;

import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "cn.tuyucheng.taketoday.multicriteria")
public class MongoConfig {

   @Bean
   public MongoTemplate mongoTemplate() {
      return new MongoTemplate(MongoClients.create("mongodb://localhost:27017/test"), "mongo_product");
   }
}