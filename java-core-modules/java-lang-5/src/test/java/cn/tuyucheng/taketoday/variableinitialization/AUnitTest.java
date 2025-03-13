package cn.tuyucheng.taketoday.variableinitialization;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import cn.tuyucheng.taketoday.variableInitialization.A;
import cn.tuyucheng.taketoday.variableInitialization.B;

public class AUnitTest {

   @Test
   public void whenCreatingTest_useDependencyInjection() {
      // given
      B b = mock(B.class);
      A a = new A(b);
   }
}
