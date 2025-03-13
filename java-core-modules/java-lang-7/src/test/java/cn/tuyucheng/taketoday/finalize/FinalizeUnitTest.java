package cn.tuyucheng.taketoday.finalize;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class FinalizeUnitTest {
   @Test
   public void whenGC_thenFinalizerExecuted() throws IOException {
      String firstLine = new Finalizable().readFirstLine();
      Assert.assertEquals("taketoday.com", firstLine);
      System.gc();
   }

   @Test
   public void whenTryWResourcesExits_thenResourceClosed() throws IOException {
      try (CloseableResource resource = new CloseableResource()) {
         String firstLine = resource.readFirstLine();
         Assert.assertEquals("taketoday.com", firstLine);
      }
   }
}
