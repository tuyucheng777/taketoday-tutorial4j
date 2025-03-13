package cn.tuyucheng.taketoday.core.scope;

public class NestedScopesExample {

   String title = "Taketoday";

   public void printTitle() {
      System.out.println(title);
      String title = "John Doe";
      System.out.println(title);
   }
}