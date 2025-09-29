package cn.tuyucheng.taketoday.nullobject;

public class RouterFactory {

   public static Router getRouterForMessage(Message msg) {
      if (msg.getPriority() == null) {
         return new NullRouter();
      }

      return switch (msg.getPriority()) {
         case "high" -> new SmsRouter();
         case "medium" -> new JmsRouter();
         default -> new NullRouter();
      };
   }
}