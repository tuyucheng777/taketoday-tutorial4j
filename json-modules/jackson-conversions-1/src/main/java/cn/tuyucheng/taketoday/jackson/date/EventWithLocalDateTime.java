package cn.tuyucheng.taketoday.jackson.date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDateTime;

public class EventWithLocalDateTime {
   public String name;

   @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
   public LocalDateTime eventDate;

   public EventWithLocalDateTime() {
      super();
   }

   public EventWithLocalDateTime(final String name, final LocalDateTime eventDate) {
      this.name = name;
      this.eventDate = eventDate;
   }

   public LocalDateTime getEventDate() {
      return eventDate;
   }

   public String getName() {
      return name;
   }
}
