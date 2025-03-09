package cn.tuyucheng.taketoday.streams.gettersreturningnull;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TaketodayReflectionUtilsUnitTest {

   @Test
   public void givenCustomer_whenAFieldIsNull_thenFieldNameInResult() throws Exception {
      Customer customer = new Customer(1, "Himanshu", null, null);

      List<String> result = Utils.getNullPropertiesList(customer);
      List<String> expectedFieldNames = Arrays.asList("emailId", "phoneNumber");

      assertEquals(result.size(), expectedFieldNames.size());
      assertTrue(result.containsAll(expectedFieldNames));
   }
}