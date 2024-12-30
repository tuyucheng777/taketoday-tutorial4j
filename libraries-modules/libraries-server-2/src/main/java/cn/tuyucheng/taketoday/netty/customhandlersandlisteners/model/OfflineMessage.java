package cn.tuyucheng.taketoday.netty.customhandlersandlisteners.model;

public class OfflineMessage extends Message {

   public OfflineMessage(String info) {
      super("system", "client went offline: " + info);
   }
}