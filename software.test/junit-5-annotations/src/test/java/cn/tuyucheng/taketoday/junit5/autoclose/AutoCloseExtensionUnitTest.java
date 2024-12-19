package cn.tuyucheng.taketoday.junit5.autoclose;

import org.junit.jupiter.api.AutoClose;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AutoCloseExtensionUnitTest {

   @AutoClose
   DummyAutoCloseableResource resource = new DummyAutoCloseableResource();

   @AutoClose("clear")
   DummyClearableResource clearResource = new DummyClearableResource();

   @Test
   void whenUsingDummyAutoCloseableResource_thenResourceIsOpen() {
      assertTrue(resource.isOpen());
   }

   @Test
   void whenUsingUsingDummyClearableResource_thenResourceIsNotCleared() {
      assertFalse(clearResource.isClear());
   }
}