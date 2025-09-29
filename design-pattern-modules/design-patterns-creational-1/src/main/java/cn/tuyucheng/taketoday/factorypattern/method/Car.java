package cn.tuyucheng.taketoday.factorypattern.method;

public class Car implements MotorVehicle {
   @Override
   public void build() {
      System.out.println("Build Car");
   }
}