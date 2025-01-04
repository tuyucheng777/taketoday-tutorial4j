package cn.tuyucheng.taketoday.apache.camel.logging;

import org.apache.camel.Body;

import java.util.Map;

public class FileProcessor {

   public String process(@Body String fileContent) {
      return fileContent.toUpperCase();
   }

   public Map<String, Object> transform(Map<String, Object> input) {
      String name = (String) input.get("name");
      int age = (int) input.get("age");

      input.put("transformedName", name.toUpperCase());
      input.put("transformedAge", age + 10);

      return input;
   }
}