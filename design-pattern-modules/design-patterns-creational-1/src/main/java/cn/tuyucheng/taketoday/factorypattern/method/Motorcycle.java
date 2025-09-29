package cn.tuyucheng.taketoday.factorypattern.method;

public class Motorcycle implements MotorVehicle {
   @Override
   public void build() {
      System.out.println("Build Motorcycle");
   }
}