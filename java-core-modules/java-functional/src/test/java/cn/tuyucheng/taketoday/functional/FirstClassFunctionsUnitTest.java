package cn.tuyucheng.taketoday.functional;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstClassFunctionsUnitTest {

   @Test
   public void testSortingWithoutLambda() {

      assertEquals(Integer.valueOf(8),
            FirstClassFunctions.sortWithoutLambda(Arrays.asList(10, 8)).get(0));

   }

   @Test
   public void testSortingWithLambda() {

      assertEquals(Integer.valueOf(8),
            FirstClassFunctions.sortWithLambda(Arrays.asList(10, 8)).get(0));

   }

}
