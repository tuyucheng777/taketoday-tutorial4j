package cn.tuyucheng.taketoday.marketing.mailshots;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class SplittingNamesFixture {

   public Result split(String fullName) {
      Result result = new Result();
      String[] words = fullName.split(" ");
      result.firstName = words[0];
      result.lastName = words[1];
      return result;
   }

   class Result {
      public String firstName;
      public String lastName;
   }
}