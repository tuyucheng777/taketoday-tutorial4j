package cn.tuyucheng.taketoday.junit5vstestng;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderedUnitTest {

   @Test
   @Order(2)
   void a_givenString_whenChangedtoInt_thenTrue() {
      assertTrue(Integer.valueOf("10") instanceof Integer);
   }

   @Test
   @Order(1)
   void b_givenInt_whenChangedtoString_thenTrue() {
      assertTrue(String.valueOf(10) instanceof String);
   }
}