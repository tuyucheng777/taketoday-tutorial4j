package cn.tuyucheng.taketoday.gson.deserialization;

import com.google.gson.*;

import java.lang.reflect.Type;

public class FooDeserializer implements JsonDeserializer<Foo[]> {

   @Override
   public Foo[] deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context) throws JsonParseException {
      final JsonArray jArray = json.getAsJsonArray();
      final Foo[] scArray = new Foo[jArray.size()];
      int index = 0;
      for (final JsonElement jElement : jArray) {
         final int i = jElement.getAsJsonObject().get("intValue").getAsInt();
         final String s = jElement.getAsJsonObject().get("stringValue").getAsString();
         scArray[index++] = new Foo(i, s);
      }
      return scArray;
   }
}