package cn.tuyucheng.taketoday.passcollectiontovarargs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PassCollectionToVarargsUnitTest {

   private List<String> listOfStrings;

   @Test
   void givenList_whenUsingCollectionToArray_thenInvokeVarargsMethod() {
      assertDoesNotThrow(() -> method(listOfStrings.toArray(new String[0])));
   }

   @Test
   void givenList_whenUsingForLoopToPopulateArray_thenInvokeVarargsMethod() {
      String[] array = new String[listOfStrings.size()];
      for (int i = 0; i < listOfStrings.size(); i++) {
         array[i] = listOfStrings.get(i);
      }
      assertDoesNotThrow(() -> method(array));
   }

   @Test
   void givenList_whenUsingStreamAPI_thenInvokeVarargsMethod() {
      String[] array = listOfStrings.stream()
            .toArray(String[]::new);
      assertDoesNotThrow(() -> method(array));
   }

   @BeforeEach
   void init() {
      listOfStrings = List.of("string one", "string two", "string three");
   }

   private void method(String... strings) {
   }
}