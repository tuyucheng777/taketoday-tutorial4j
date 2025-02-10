package cn.tuyucheng.taketoday.mapstruct.inheritance.mapper;

import org.mapstruct.Mapper;

import cn.tuyucheng.taketoday.mapstruct.inheritance.model.Bus;
import cn.tuyucheng.taketoday.mapstruct.inheritance.model.dto.BusDTO;
import cn.tuyucheng.taketoday.mapstruct.inheritance.model.Car;
import cn.tuyucheng.taketoday.mapstruct.inheritance.model.dto.CarDTO;
import cn.tuyucheng.taketoday.mapstruct.inheritance.model.Vehicle;
import cn.tuyucheng.taketoday.mapstruct.inheritance.model.dto.VehicleDTO;
import cn.tuyucheng.taketoday.mapstruct.inheritance.model.Visitor;

@Mapper()
public abstract class VehicleMapperByVisitorPattern implements Visitor {

   public VehicleDTO mapToVehicleDTO(Vehicle vehicle) {
      return vehicle.accept(this);
   }

   @Override
   public VehicleDTO visit(Car car) {
      return map(car);
   }

   @Override
   public VehicleDTO visit(Bus bus) {
      return map(bus);
   }

   abstract CarDTO map(Car car);

   abstract BusDTO map(Bus bus);
}