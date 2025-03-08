package cn.tuyucheng.taketoday.algorithms.pixelarray;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static cn.tuyucheng.taketoday.algorithms.pixelarray.GetPixelArray.get2DPixelArrayFast;
import static cn.tuyucheng.taketoday.algorithms.pixelarray.GetPixelArray.get2DPixelArraySlow;
import static org.junit.Assert.assertTrue;

public class GetPixelArrayUnitTest {
   @Test
   public void givenImage_whenGetPixelArray_thenBothMethodsReturnEqualValues() {
      BufferedImage sampleImage = null;
      try {
         sampleImage = ImageIO.read(new File("src/main/resources/images/sampleImage.jpg"));
      } catch (IOException e) {
         throw new RuntimeException(e);
      }

      int[][] firstResult = get2DPixelArraySlow(sampleImage);
      int[][] secondResult = get2DPixelArrayFast(sampleImage);

      assertTrue(Arrays.deepEquals(firstResult, secondResult));
   }
}
