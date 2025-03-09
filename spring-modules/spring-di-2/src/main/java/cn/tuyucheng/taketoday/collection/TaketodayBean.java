package cn.tuyucheng.taketoday.collection;

public class TaketodayBean {

   private String name;

   public TaketodayBean(String name) {
      this.name = name;
   }

   @Override
   public String toString() {
      return name;
   }
}