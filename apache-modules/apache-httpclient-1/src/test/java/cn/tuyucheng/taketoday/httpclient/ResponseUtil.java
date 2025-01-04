package cn.tuyucheng.taketoday.httpclient;

import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.HttpEntity;

import java.io.IOException;

public final class ResponseUtil {
   private ResponseUtil() {
   }

   public static void closeResponse(CloseableHttpResponse response) throws IOException {
      if (response == null) {
         return;
      }

      try (response) {
         final HttpEntity entity = response.getEntity();
         if (entity != null) {
            entity.getContent().close();
         }
      }
   }
}