package cn.tuyucheng.taketoday.junit5vstestng;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.MethodName.class)
class SortedUnitTest {

   @Test
   void a_givenString_whenChangedtoInt_thenTrue() {
      assertTrue(Integer.valueOf("10") instanceof Integer);
   }

   @Test
   void b_givenInt_whenChangedtoString_thenTrue() {
      assertTrue(String.valueOf(10) instanceof String);
   }
}