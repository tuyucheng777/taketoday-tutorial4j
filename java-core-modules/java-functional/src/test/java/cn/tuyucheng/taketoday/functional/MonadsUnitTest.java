package cn.tuyucheng.taketoday.functional;

import org.junit.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonadsUnitTest {

   @Test
   public void testOptionalAdd() {

      assertEquals(Integer.valueOf(5),
            Monads.add(Optional.of(2), Optional.of(3)).get());

   }

}
