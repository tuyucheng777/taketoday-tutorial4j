package cn.tuyucheng.taketoday.formatinstantobjectmapper.serializer;

import cn.tuyucheng.taketoday.formatinstantobjectmapper.utils.Instants;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;

public class GlobalInstantSerializer extends InstantSerializer {
   private static final long serialVersionUID = 1L;

   public GlobalInstantSerializer() {
      super(InstantSerializer.INSTANCE, false, false, Instants.FORMATTER);
   }
}
