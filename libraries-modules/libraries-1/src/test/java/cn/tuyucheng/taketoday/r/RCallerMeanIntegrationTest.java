package cn.tuyucheng.taketoday.r;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import javax.script.ScriptException;
import java.io.IOException;
import java.net.URISyntaxException;

@Ignore
public class RCallerMeanIntegrationTest {

   /**
    * Object to test.
    */
   private RCallerMean rcallerMean = new RCallerMean();

   /**
    * Test for {@link RCallerMeanIntegrationTest#mean(int[])}.
    *
    * @throws ScriptException    if an error occurs
    * @throws URISyntaxException if an error occurs
    */
   @Test
   public void givenValues_whenMean_thenCorrect() throws IOException, URISyntaxException {
      int[] input = {1, 2, 3, 4, 5};
      double result = rcallerMean.mean(input);
      Assert.assertEquals(3.0, result, 0.000001);
   }
}