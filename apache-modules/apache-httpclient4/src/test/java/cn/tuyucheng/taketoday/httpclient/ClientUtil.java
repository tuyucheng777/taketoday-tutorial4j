package cn.tuyucheng.taketoday.httpclient;

import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;

public final class ClientUtil {

   private ClientUtil() {
   }

   public static void closeClient(CloseableHttpClient client) throws IOException {
      if (client == null) {
         return;
      }

      client.close();
   }
}