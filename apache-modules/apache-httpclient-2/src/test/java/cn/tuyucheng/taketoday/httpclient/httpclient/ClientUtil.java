package cn.tuyucheng.taketoday.httpclient.httpclient;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;

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