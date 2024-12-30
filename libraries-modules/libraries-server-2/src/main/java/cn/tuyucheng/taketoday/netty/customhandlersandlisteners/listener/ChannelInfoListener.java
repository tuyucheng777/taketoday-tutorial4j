package cn.tuyucheng.taketoday.netty.customhandlersandlisteners.listener;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.util.concurrent.GenericFutureListener;

import java.time.Instant;

public class ChannelInfoListener implements GenericFutureListener<ChannelFuture> {

   private final String event;

   public ChannelInfoListener(String event) {
      this.event = event;
   }

   @Override
   public void operationComplete(ChannelFuture future) throws Exception {
      Channel channel = future.channel();
      String status = "OK";

      if (!future.isSuccess()) {
         status = "FAILED";
         future.cause()
               .printStackTrace();
      }

      System.out.printf("%s - channel#%s %s: %s%n", Instant.now(), channel.id()
            .asShortText(), status, event);
   }
}