package cn.tuyucheng.taketoday.resourcebundle;

import java.util.ListResourceBundle;

public class ExampleResource extends ListResourceBundle {

   @Override
   protected Object[][] getContents() {
      return new Object[][]{
            {"greeting", "hello"}
      };
   }

}
