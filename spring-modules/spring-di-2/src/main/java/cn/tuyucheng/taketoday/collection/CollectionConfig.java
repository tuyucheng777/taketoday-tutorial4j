package cn.tuyucheng.taketoday.collection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.*;

@Configuration
public class CollectionConfig {

   @Bean
   public CollectionsBean getCollectionsBean() {
      return new CollectionsBean(new HashSet<>(Arrays.asList("John", "Adam", "Harry")));
   }

   @Bean
   public List<String> nameList() {
      return Arrays.asList("John", "Adam", "Harry", null);
   }

   @Bean
   public Map<Integer, String> nameMap() {
      Map<Integer, String> nameMap = new HashMap<>();
      nameMap.put(1, "John");
      nameMap.put(2, "Adam");
      nameMap.put(3, "Harry");
      return nameMap;
   }

   @Bean
   @Qualifier("CollectionsBean")
   @Order(2)
   public TaketodayBean getElement() {
      return new TaketodayBean("John");
   }

   @Bean
   @Order(3)
   public TaketodayBean getAnotherElement() {
      return new TaketodayBean("Adam");
   }

   @Bean
   @Order(1)
   public TaketodayBean getOneMoreElement() {
      return new TaketodayBean("Harry");
   }
}