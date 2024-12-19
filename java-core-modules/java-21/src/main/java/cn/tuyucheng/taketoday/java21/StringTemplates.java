package cn.tuyucheng.taketoday.java21;

public class StringTemplates {

   public String getStringTemplate() {
      String name = "Tuyucheng";
      return STR."Welcome to \{name}";
   }
}