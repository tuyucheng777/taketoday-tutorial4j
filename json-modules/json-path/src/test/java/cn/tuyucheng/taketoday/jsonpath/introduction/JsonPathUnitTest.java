package cn.tuyucheng.taketoday.jsonpath.introduction;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class JsonPathUnitTest {

   private static String json;
   private static File jsonFile = new File("src/main/resources/online_store.json");

   private static String readFile(File file) throws IOException {
      return Files.readString(file.toPath(), StandardCharsets.UTF_8);
   }

   @BeforeClass
   public static void init() throws IOException {
      json = readFile(jsonFile);
   }

   @Test
   public void shouldMatchCountOfObjects() {
      Map<String, String> objectMap = JsonPath.read(json, "$");
      assertEquals(3, objectMap.keySet()
            .size());
   }

   @Test
   public void shouldMatchCountOfArrays() {
      JSONArray jsonArray = JsonPath.read(json, "$.items.book[*]");
      assertEquals(2, jsonArray.size());
   }
}