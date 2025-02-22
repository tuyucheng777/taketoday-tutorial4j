package cn.tuyucheng.taketoday.formatinstantobjectmapper.serializer;

import cn.tuyucheng.taketoday.formatinstantobjectmapper.utils.Instants;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;

import java.time.Instant;

public class GlobalInstantDeserializer extends InstantDeserializer<Instant> {
   private static final long serialVersionUID = 1L;

   public GlobalInstantDeserializer() {
      super(InstantDeserializer.INSTANT, Instants.FORMATTER);
   }
}
