package cn.tuyucheng.taketoday.formatinstantobjectmapper;

import cn.tuyucheng.taketoday.formatinstantobjectmapper.utils.Instants;
import cn.tuyucheng.taketoday.formatinstantobjectmapper.utils.TimeStampTracker;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;

public class Session implements TimeStampTracker {

   private String name;

   @JsonFormat(pattern = Instants.DATE_FORMAT, timezone = "UTC")
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
