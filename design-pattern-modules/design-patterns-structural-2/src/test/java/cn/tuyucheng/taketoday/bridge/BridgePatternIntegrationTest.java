package cn.tuyucheng.taketoday.bridge;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BridgePatternIntegrationTest {

   @Test
   public void whenBridgePatternInvoked_thenConfigSuccess() {
      // a square with red color
      Shape square = new Square(new Red());
      assertEquals("Square drawn. Color is Red", square.draw());

      // a triangle with blue color
      Shape triangle = new Triangle(new Blue());
      assertEquals("Triangle drawn. Color is Blue", triangle.draw());
   }
}