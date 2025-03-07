package cn.tuyucheng.taketoday.undertow;

import io.undertow.Undertow;
import io.undertow.util.Headers;

public class SimpleServer {

   public static void main(String[] args) {
      Undertow server = Undertow.builder().addHttpListener(8080, "localhost").setHandler(exchange -> {
         exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
         exchange.getResponseSender().send("Hello Taketoday");
      }).build();
      server.start();
   }
}