package cn.tuyucheng.taketoday.conditionalflow.step;

import cn.tuyucheng.taketoday.conditionalflow.model.NumberInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberInfoGeneratorUnitTest {

   @Test
   public void givenArray_whenGenerator_correctOrderAndValue() {
      int[] numbers = new int[]{1, -2, 4, -10};
      NumberInfoGenerator numberGenerator = new NumberInfoGenerator(numbers);
      Assertions.assertEquals(new NumberInfo(numbers[0]), numberGenerator.read());
      Assertions.assertEquals(new NumberInfo(numbers[1]), numberGenerator.read());
      Assertions.assertEquals(new NumberInfo(numbers[2]), numberGenerator.read());
      Assertions.assertEquals(new NumberInfo(numbers[3]), numberGenerator.read());
      Assertions.assertNull(numberGenerator.read());
   }
}