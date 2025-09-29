package cn.tuyucheng.taketoday.flyweight;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

/**
 * Unit test for {@link VehicleFactory}.
 */
public class FlyweightUnitTest {

   /**
    * Checks that when the {@link VehicleFactory} is asked to provide two
    * vehicles of different colors, the objects returned are different.
    */
   @Test
   public void givenDifferentFlyweightObjects_whenEquals_thenFalse() {
      Vehicle blackVehicle = VehicleFactory.createVehicle(Color.BLACK);
      Vehicle blueVehicle = VehicleFactory.createVehicle(Color.BLUE);

      Assert.assertNotNull("Object returned by the factory is null!", blackVehicle);
      Assert.assertNotNull("Object returned by the factory is null!", blueVehicle);
      Assert.assertNotEquals("Objects returned by the factory are equals!", blackVehicle, blueVehicle);
   }

   /**
    * Checks that when the {@link VehicleFactory} is asked to provide two
    * vehicles of the same colors, the same object is returned twice.
    */
   @Test
   public void givenSameFlyweightObjects_whenEquals_thenTrue() {
      Vehicle blackVehicle = VehicleFactory.createVehicle(Color.BLACK);
      Vehicle anotherBlackVehicle = VehicleFactory.createVehicle(Color.BLACK);

      Assert.assertNotNull("Object returned by the factory is null!", blackVehicle);
      Assert.assertNotNull("Object returned by the factory is null!", anotherBlackVehicle);
      Assert.assertEquals("Objects returned by the factory are not equals!", blackVehicle, anotherBlackVehicle);
   }
}