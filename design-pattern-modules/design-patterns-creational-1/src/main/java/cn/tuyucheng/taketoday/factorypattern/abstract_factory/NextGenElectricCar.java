package cn.tuyucheng.taketoday.factorypattern.abstract_factory;

public class NextGenElectricCar implements ElectricVehicle {
   @Override
   public void build() {
      System.out.println("NextGen Electric Car");
   }
}