package cn.tuyucheng.taketoday.stringconversions;

import java.time.LocalDateTime;

public class UseLocalDateTime {

   public LocalDateTime getLocalDateTimeUsingParseMethod(String representation) {
      return LocalDateTime.parse(representation);
   }

}
