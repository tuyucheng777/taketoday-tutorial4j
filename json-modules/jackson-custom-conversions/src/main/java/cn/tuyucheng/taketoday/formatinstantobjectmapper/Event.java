package cn.tuyucheng.taketoday.formatinstantobjectmapper;

import cn.tuyucheng.taketoday.formatinstantobjectmapper.serializer.CustomInstantDeserializer;
import cn.tuyucheng.taketoday.formatinstantobjectmapper.serializer.CustomInstantSerializer;
import cn.tuyucheng.taketoday.formatinstantobjectmapper.utils.TimeStampTracker;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.Instant;

public class Event implements TimeStampTracker {

   private String name;

   @JsonSerialize(using = CustomInstantSerializer.class)
   @JsonDeserialize(using = CustomInstantDeserializer.class)
   private Instant timeStamp;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @Override
   public Instant getTimeStamp() {
      return timeStamp;
   }

   public void setTimeStamp(Instant timeStamp) {
      this.timeStamp = timeStamp;
   }
}
