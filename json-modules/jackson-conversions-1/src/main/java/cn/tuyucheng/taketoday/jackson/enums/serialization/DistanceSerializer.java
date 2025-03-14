package cn.tuyucheng.taketoday.jackson.enums.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class DistanceSerializer extends StdSerializer<Distance> {

   private static final long serialVersionUID = 1376504304439963619L;

   public DistanceSerializer() {
      super(Distance.class);
   }

   public DistanceSerializer(Class<Distance> t) {
      super(t);
   }

   public void serialize(Distance distance, JsonGenerator generator, SerializerProvider provider) throws IOException, JsonProcessingException {
      generator.writeStartObject();
      generator.writeFieldName("name");
      generator.writeString(distance.name());
      generator.writeFieldName("unit");
      generator.writeString(distance.getUnit());
      generator.writeFieldName("meters");
      generator.writeNumber(distance.getMeters());
      generator.writeEndObject();
   }
}
