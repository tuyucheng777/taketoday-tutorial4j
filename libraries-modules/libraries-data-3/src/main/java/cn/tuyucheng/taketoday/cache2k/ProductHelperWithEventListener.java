package cn.tuyucheng.taketoday.cache2k;

import org.cache2k.Cache;
import org.cache2k.Cache2kBuilder;
import org.cache2k.event.CacheEntryCreatedListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ProductHelperWithEventListener {

   final Logger LOGGER = LoggerFactory.getLogger(ProductHelperWithEventListener.class);

   private Cache<String, Integer> cachedDiscounts;

   private int cacheMissCount = 0;

   public ProductHelperWithEventListener() {
      cachedDiscounts = Cache2kBuilder.of(String.class, Integer.class)
            .name("discount-listener")
            .expireAfterWrite(10, TimeUnit.MILLISECONDS)
            .entryCapacity(100)
            .loader((key) -> {
               cacheMissCount++;
               return "Sports".equalsIgnoreCase(key) ? 20 : 10;
            })
            .addListener((CacheEntryCreatedListener<String, Integer>) (_, entry) -> LOGGER.info("Entry created: [{}, {}].", entry.getKey(), entry.getValue()))
            .build();
   }

   public Integer getDiscount(String productType) {
      return cachedDiscounts.get(productType);
   }

   public int getCacheMissCount() {
      return cacheMissCount;
   }
}