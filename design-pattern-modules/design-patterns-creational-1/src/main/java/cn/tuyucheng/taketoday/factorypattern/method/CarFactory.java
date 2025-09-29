package cn.tuyucheng.taketoday.factorypattern.method;

public class CarFactory extends MotorVehicleFactory {
   @Override
   protected MotorVehicle createMotorVehicle() {
      return new Car();
   }
}