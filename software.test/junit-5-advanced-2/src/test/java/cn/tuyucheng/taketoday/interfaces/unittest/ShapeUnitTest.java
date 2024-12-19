package cn.tuyucheng.taketoday.interfaces.unittest;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class ShapeUnitTest {

   public abstract Map<String, Object> instantiateShapeWithExpectedArea();

   @Test
   void givenShapeInstance_whenAreaIsCalculated_thenSuccessful() {
      Map<String, Object> shapeAreaMap = instantiateShapeWithExpectedArea();
      Shape shape = (Shape) shapeAreaMap.get("shape");
      double expectedArea = (double) shapeAreaMap.get("area");
      double area = shape.area();
      assertEquals(expectedArea, area);
   }
}