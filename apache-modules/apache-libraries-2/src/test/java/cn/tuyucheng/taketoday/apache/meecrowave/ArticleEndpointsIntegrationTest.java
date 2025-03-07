package cn.tuyucheng.taketoday.apache.meecrowave;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.meecrowave.Meecrowave;
import org.apache.meecrowave.junit.MonoMeecrowave;
import org.apache.meecrowave.testing.ConfigurationInject;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(MonoMeecrowave.Runner.class)
public class ArticleEndpointsIntegrationTest {

   @ConfigurationInject
   private Meecrowave.Builder config;
   private static OkHttpClient client;

   @BeforeClass
   public static void setup() {
      client = new OkHttpClient();
   }

   @Test
   public void whenRetunedArticle_thenCorrect() throws IOException {
      final String base = "http://localhost:" + config.getHttpPort();

      Request request = new Request.Builder()
            .url(base + "/article")
            .build();
      Response response = client.newCall(request).execute();
      assertEquals(200, response.code());
   }
}