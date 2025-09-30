package cn.tuyucheng.taketoday.flexibleconstructorbodies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlexibleConstructorBodiesTest {

   @Test
   void test() {
      SmallCoffee smallCoffee = new SmallCoffee(30, 40, "none");
      assertEquals(70, smallCoffee.getTotalVolume());
   }
}