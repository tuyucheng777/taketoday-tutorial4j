package cn.tuyucheng.taketoday.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;

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