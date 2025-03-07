package cn.tuyucheng.taketoday.maths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalImplUnitTest {

   @Test
   public void givenBigDecimalNumbers_whenAddedTogether_thenGetExpectedResult() {
      BigDecimal serviceTax = new BigDecimal("56.0084578639");
      serviceTax = serviceTax.setScale(2, RoundingMode.CEILING);

      BigDecimal entertainmentTax = new BigDecimal("23.00689");
      entertainmentTax = entertainmentTax.setScale(2, RoundingMode.FLOOR);

      BigDecimal totalTax = serviceTax.add(entertainmentTax);
      BigDecimal result = BigDecimal.valueOf(79.01);

      Assertions.assertEquals(result, totalTax);

   }
}
