package cn.tuyucheng.taketoday.state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class StatePatternUnitTest {

   @Test
   public void givenNewPackage_whenPackageReceived_thenStateReceived() {
      Package pkg = new Package();

      assertInstanceOf(OrderedState.class, pkg.getState());
      pkg.nextState();

      assertInstanceOf(DeliveredState.class, pkg.getState());
      pkg.nextState();

      assertInstanceOf(ReceivedState.class, pkg.getState());
   }

   @Test
   public void givenDeliveredPackage_whenPrevState_thenStateOrdered() {
      Package pkg = new Package();
      pkg.setState(new DeliveredState());
      pkg.previousState();

      assertInstanceOf(OrderedState.class, pkg.getState());
   }
}