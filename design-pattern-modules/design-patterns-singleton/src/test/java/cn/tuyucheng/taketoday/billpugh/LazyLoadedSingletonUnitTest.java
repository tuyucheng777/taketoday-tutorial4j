package cn.tuyucheng.taketoday.billpugh;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LazyLoadedSingletonUnitTest {

   @Test
   void givenLazyLoadedImpl_whenCallGetInstance_thenReturnSingleInstance() throws ClassNotFoundException {
      Class bs = Class.forName("cn.tuyucheng.taketoday.billpugh.LazyLoadedSingleton");
      assertThrows(IllegalAccessException.class, () -> bs.getDeclaredConstructor().newInstance());

      LazyLoadedSingleton lazyLoadedSingletonObj1 = LazyLoadedSingleton.getInstance();
      LazyLoadedSingleton lazyLoadedSingletonObj2 = LazyLoadedSingleton.getInstance();
      assertEquals(lazyLoadedSingletonObj1.hashCode(), lazyLoadedSingletonObj2.hashCode());
   }
}