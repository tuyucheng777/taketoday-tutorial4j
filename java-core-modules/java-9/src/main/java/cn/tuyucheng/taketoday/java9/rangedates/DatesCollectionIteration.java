package cn.tuyucheng.taketoday.java9.rangedates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Date;

public class DatesCollectionIteration {
   private static final Logger log = LoggerFactory.getLogger(DatesCollectionIteration.class);

   public void iteratingRangeOfDatesJava7(Collection<Date> dates) {
      for (Date date : dates) {
         processDate(date);
      }
   }

   public void iteratingRangeOfDatesJava8(Collection<Date> dates) {
      dates.forEach(this::processDate);
   }

   private void processDate(Date date) {
      log.debug(date.toString());
   }
}