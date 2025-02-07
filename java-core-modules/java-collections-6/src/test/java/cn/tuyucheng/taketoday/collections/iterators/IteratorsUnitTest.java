package cn.tuyucheng.taketoday.collections.iterators;

import org.junit.Test;

import java.util.ConcurrentModificationException;

import static cn.tuyucheng.taketoday.collections.iterators.Iterators.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Source code https://github.com/eugenp/tutorials
 *
 * @author Santosh Thakur
 */

public class IteratorsUnitTest {

   @Test
   public void whenFailFast_ThenThrowsException() {
      assertThatThrownBy(() -> {
         failFast1();
      }).isInstanceOf(ConcurrentModificationException.class);
   }

   @Test
   public void whenFailFast_ThenThrowsExceptionInSecondIteration() {
      assertThatThrownBy(() -> {
         failFast2();
      }).isInstanceOf(ConcurrentModificationException.class);
   }

   @Test
   public void whenFailSafe_ThenDoesNotThrowException() {
      assertThat(failSafe1()).isGreaterThanOrEqualTo(0);
   }

}
