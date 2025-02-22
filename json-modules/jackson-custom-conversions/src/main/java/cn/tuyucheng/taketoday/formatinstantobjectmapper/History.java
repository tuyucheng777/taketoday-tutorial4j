package cn.tuyucheng.taketoday.formatinstantobjectmapper;

import cn.tuyucheng.taketoday.formatinstantobjectmapper.utils.TimeStampTracker;

import java.time.Instant;

public class History implements TimeStampTracker {

   private String name;

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
