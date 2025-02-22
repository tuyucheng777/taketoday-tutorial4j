package cn.tuyucheng.taketoday.formatinstantobjectmapper.serializer;

import cn.tuyucheng.taketoday.formatinstantobjectmapper.utils.Instants;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;

public class CustomInstantDeserializer extends JsonDeserializer<Instant> {

   @Override
   public Instant deserialize(JsonParser json, DeserializationContext context) throws IOException {
      return Instant.from(Instants.FORMATTER.parse(json.getText()));
   }
}