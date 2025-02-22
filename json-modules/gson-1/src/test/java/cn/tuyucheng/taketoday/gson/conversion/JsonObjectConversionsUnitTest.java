package cn.tuyucheng.taketoday.gson.conversion;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JsonObjectConversionsUnitTest {

   @Test
   void whenUsingJsonParser_thenConvertToJsonObject() throws Exception {
      // Example 1: Using JsonParser
      String json = "{ \"name\": \"Taketoday\", \"java\": true }";

      JsonObject jsonObject = JsonParser.parseString(json)
            .getAsJsonObject();

      assertTrue(jsonObject.isJsonObject());
      assertEquals("Taketoday", jsonObject.get("name")
            .getAsString());
      assertTrue(jsonObject.get("java")
            .getAsBoolean());
   }

   @Test
   void whenUsingGsonInstanceFromJson_thenConvertToJsonObject() throws Exception {
      // Example 2: Using fromJson
      String json = "{ \"name\": \"Taketoday\", \"java\": true }";

      JsonObject convertedObject = new Gson().fromJson(json, JsonObject.class);

      assertTrue(convertedObject.isJsonObject());
      assertEquals("Taketoday", convertedObject.get("name")
            .getAsString());
      assertTrue(convertedObject.get("java")
            .getAsBoolean());
   }
}