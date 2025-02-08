package cn.tuyucheng.taketoday.functional;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PureFunctionsUnitTets {

   @Test
   public void testSortingWithoutLambda() {

      assertEquals(Integer.valueOf(18), PureFunctions.sum(Arrays.asList(10, 8)));
   }

}
