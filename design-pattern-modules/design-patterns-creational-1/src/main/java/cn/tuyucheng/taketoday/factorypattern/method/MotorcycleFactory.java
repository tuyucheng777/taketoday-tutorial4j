package cn.tuyucheng.taketoday.factorypattern.method;

public class MotorcycleFactory extends MotorVehicleFactory {
   @Override
   protected MotorVehicle createMotorVehicle() {
      return new Motorcycle();
   }
}