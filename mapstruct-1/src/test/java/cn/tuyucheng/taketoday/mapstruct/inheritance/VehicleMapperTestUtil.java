package cn.tuyucheng.taketoday.mapstruct.inheritance;

import cn.tuyucheng.taketoday.mapstruct.inheritance.model.Bus;
import cn.tuyucheng.taketoday.mapstruct.inheritance.model.Car;

public final class VehicleMapperTestUtil {

   private VehicleMapperTestUtil() {

   }

   public static Car getCarInstance() {
      Car car = new Car();
      car.setColor("Yellow");
      car.setSpeed("50 KM-PH");
      car.setTires(4);

      return car;
   }

   public static Bus getBusInstance() {
      Bus bus = new Bus();
      bus.setColor("Blue");
      bus.setSpeed("30 KM-PH");
      bus.setCapacity(50);

      return bus;
   }
}