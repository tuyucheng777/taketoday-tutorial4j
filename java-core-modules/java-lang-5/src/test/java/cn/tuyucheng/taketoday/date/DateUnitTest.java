package cn.tuyucheng.taketoday.date;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class DateUnitTest {

   @Test
   public void whenUsingFullyQualifiedClassNames() {

      java.util.Date javaDate = new java.util.Date();
      cn.tuyucheng.taketoday.date.Date taketodayDate = new cn.tuyucheng.taketoday.date.Date(javaDate.getTime());

      Assert.assertEquals(javaDate.getTime(), taketodayDate.getTime());
   }

   @Test
   public void whenImportTheMostUsedOne() {

      Date javaDate = new Date();
      cn.tuyucheng.taketoday.date.Date taketodayDate = new cn.tuyucheng.taketoday.date.Date(javaDate.getTime());

      Assert.assertEquals(javaDate.getTime(), taketodayDate.getTime());
   }
}
