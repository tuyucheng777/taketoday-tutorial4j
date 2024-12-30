package cn.tuyucheng.taketoday.cache2k;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductHelperWithExpiryUnitTest {

   @Test
   public void whenInvokedGetDiscountAfterExpiration_thenDiscountCalculatedAgain() throws InterruptedException {
      ProductHelperWithExpiry productHelper = new ProductHelperWithExpiry();
      assertEquals(0, productHelper.getCacheMissCount());
      assertEquals(20, (int) productHelper.getDiscount("Sports"));
      assertEquals(1, productHelper.getCacheMissCount());

      Thread.sleep(20);

      assertEquals(20, (int) productHelper.getDiscount("Sports"));
      assertEquals(2, productHelper.getCacheMissCount());
   }
}