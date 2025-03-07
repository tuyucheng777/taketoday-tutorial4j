package cn.tuyucheng.taketoday.peakelements;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MultiplePeakFinderUnitTest {

   @Test
   void findPeaks_givenArrayOfIntegers_whenValidInput_thenReturnsCorrectPeaks() {
      MultiplePeakFinder finder = new MultiplePeakFinder();
      int[] array = {1, 13, 7, 0, 4, 1, 4, 45, 50};
      List<Integer> peaks = finder.findPeaks(array);

      assertEquals(3, peaks.size());
      assertTrue(peaks.contains(4));
      assertTrue(peaks.contains(13));
      assertTrue(peaks.contains(50));
   }
}

