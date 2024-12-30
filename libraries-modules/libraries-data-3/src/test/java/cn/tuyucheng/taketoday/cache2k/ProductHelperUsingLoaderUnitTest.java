package cn.tuyucheng.taketoday.cache2k;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductHelperUsingLoaderUnitTest {

   @Test
   public void whenInvokedGetDiscount_thenPopulateCacheUsingLoader() {
      ProductHelperUsingLoader productHelper = new ProductHelperUsingLoader();
      assertEquals(0, productHelper.getCacheMissCount());

      assertEquals(20, (int) productHelper.getDiscount("Sports"));
      assertEquals(1, productHelper.getCacheMissCount());

      assertEquals(10, (int) productHelper.getDiscount("Electronics"));
      assertEquals(2, productHelper.getCacheMissCount());
   }
}