package cn.tuyucheng.taketoday.armeria;

import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.server.Server;
import com.linecorp.armeria.server.ServerBuilder;
import com.linecorp.armeria.server.logging.AccessLogWriter;

import java.util.concurrent.CompletableFuture;

public class PathParamsServer {
   public static void main(String[] args) {
      ServerBuilder sb = Server.builder();
      sb.http(8080);

      sb.accessLogWriter(AccessLogWriter.common(), true);

      sb.service("/handler", (_, _) -> HttpResponse.of("Hello, world!"));
      sb.service("/curly/{name}", (ctx, _) -> HttpResponse.of("Hello, " + ctx.pathParam("name")));
      sb.service("/colon/:name", (ctx, _) -> HttpResponse.of("Hello, " + ctx.pathParam("name")));
      sb.service("glob:/base/*/glob/**", (ctx, _) -> HttpResponse.of("Hello, " + ctx.pathParam("0") + ", " + ctx.pathParam("1")));
      sb.service("regex:^/regex/[A-Za-z]+/[0-9]+$", (ctx, _) -> HttpResponse.of("Hello, " + ctx.path()));
      sb.service("regex:^/named-regex/(?<name>[A-Z][a-z]+)$", (ctx, _) -> HttpResponse.of("Hello, " + ctx.pathParam("name")));

      Server server = sb.build();
      CompletableFuture<Void> future = server.start();
      future.join();
   }
}