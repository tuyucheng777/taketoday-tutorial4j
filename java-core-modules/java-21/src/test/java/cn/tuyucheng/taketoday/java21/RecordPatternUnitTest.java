package cn.tuyucheng.taketoday.java21;

import cn.tuyucheng.taketoday.java21.RecordPattern.Color;
import cn.tuyucheng.taketoday.java21.RecordPattern.ColoredPoint;
import cn.tuyucheng.taketoday.java21.RecordPattern.Point;
import cn.tuyucheng.taketoday.java21.RecordPattern.RandomPoint;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecordPatternUnitTest {

   @Test
   void whenNoRecordPattern_thenReturnOutput() {
      assertEquals(5, RecordPattern.beforeRecordPattern(new Point(2, 3)));
   }

   @Test
   void whenRecordPattern_thenReturnOutput() {
      assertEquals(5, RecordPattern.afterRecordPattern(new Point(2, 3)));
   }

   @Test
   void whenRecordPattern_thenReturnColorOutput() {
      ColoredPoint coloredPoint = new ColoredPoint(new Point(2, 3), Color.GREEN);
      RandomPoint randomPoint = new RandomPoint(coloredPoint);
      assertEquals(Color.GREEN, RecordPattern.getRamdomPointColor(randomPoint));
   }
}