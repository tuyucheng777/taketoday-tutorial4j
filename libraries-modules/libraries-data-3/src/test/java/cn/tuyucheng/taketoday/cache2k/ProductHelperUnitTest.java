package cn.tuyucheng.taketoday.cache2k;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductHelperUnitTest {

   @Test
   public void whenInvokedGetDiscountTwice_thenGetItFromCache() {
      ProductHelper productHelper = new ProductHelper();
      assertEquals(0, productHelper.getCacheMissCount());
      assertEquals(20, (int) productHelper.getDiscount("Sports"));
      assertEquals(20, (int) productHelper.getDiscount("Sports"));
      assertEquals(1, productHelper.getCacheMissCount());
   }
}