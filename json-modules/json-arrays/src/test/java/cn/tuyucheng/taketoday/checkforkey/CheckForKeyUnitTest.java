package cn.tuyucheng.taketoday.checkforkey;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckForKeyUnitTest {

   private final String exampleJson = "[{\"colour\":\"red\"},{\"colour\":\"blue\"},{\"colour\":\"green\"}]";

   @Test
   public void givenJsonArray_whenUsingJackson_thenDetectKeyInArray() throws JsonProcessingException {
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode tree = objectMapper.readTree(exampleJson);

      Stream<JsonNode> s = StreamSupport.stream(tree.spliterator(), false);
      boolean result = s.map(entry -> entry.get("colour"))
            .filter(Objects::nonNull)
            .anyMatch(colour -> "green".equals(colour.asText()));
      assertTrue(result);
   }

   @Test
   public void givenJsonArray_whenUsingGson_thenDetectKeyInArray() {
      Gson gson = new Gson();
      JsonArray parsed = gson.fromJson(exampleJson, JsonArray.class);

      Stream<JsonElement> s = StreamSupport.stream(parsed.spliterator(), false);
      boolean result = s.map(entry -> entry.getAsJsonObject()
                  .get("colour"))
            .filter(Objects::nonNull)
            .anyMatch(colour -> "green".equals(colour.getAsString()));
      assertTrue(result);
   }

}
