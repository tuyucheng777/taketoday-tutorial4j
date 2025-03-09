package cn.tuyucheng.taketoday.di.spring;

public class InstanceServiceFactory {
   public IService getService(int number) {
      return switch (number) {
         case 1 -> new MessageService("Foo");
         case 0 -> new IndexService();
         default -> throw new IllegalArgumentException("Unknown parameter " + number);
      };
   }
}