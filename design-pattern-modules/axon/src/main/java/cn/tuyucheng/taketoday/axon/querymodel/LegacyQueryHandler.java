package cn.tuyucheng.taketoday.axon.querymodel;

import cn.tuyucheng.taketoday.axon.coreapi.queries.TotalProductsShippedQuery;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

@Service
public class LegacyQueryHandler {

   @QueryHandler
   public Integer handle(TotalProductsShippedQuery query) {
      return switch (query.getProductId()) {
         case "Deluxe Chair" -> 234;
         case "a6aa01eb-4e38-4dfb-b53b-b5b82961fbf3" -> 10;
         default -> 0;
      };
   }
}