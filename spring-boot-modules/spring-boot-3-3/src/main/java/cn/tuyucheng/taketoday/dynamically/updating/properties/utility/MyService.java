package cn.tuyucheng.taketoday.dynamically.updating.properties.utility;

public class MyService {

   private final String property;

   public MyService(String property) {
      this.property = property;
   }

   public String getProperty() {
      return property;
   }
}