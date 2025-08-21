package cn.tuyucheng.taketoday.classtemplate;

public class Greeter {

   public String greet(String name, String language) {
      return "it".equals(language) ? "Ciao " + name : "Hello " + name;
   }
}