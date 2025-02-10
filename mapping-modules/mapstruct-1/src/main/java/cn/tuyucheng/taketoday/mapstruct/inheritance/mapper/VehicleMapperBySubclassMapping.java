package cn.tuyucheng.taketoday.mapstruct.inheritance.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.SubclassMapping;

import cn.tuyucheng.taketoday.mapstruct.inheritance.model.Bus;
import cn.tuyucheng.taketoday.mapstruct.inheritance.model.dto.BusDTO;
import cn.tuyucheng.taketoday.mapstruct.inheritance.model.Car;
import cn.tuyucheng.taketoday.mapstruct.inheritance.model.dto.CarDTO;
import cn.tuyucheng.taketoday.mapstruct.inheritance.model.Vehicle;
import cn.tuyucheng.taketoday.mapstruct.inheritance.model.dto.VehicleDTO;

@Mapper()
public interface VehicleMapperBySubclassMapping {

   @SubclassMapping(source = Car.class, target = CarDTO.class)
   @SubclassMapping(source = Bus.class, target = BusDTO.class)
   VehicleDTO mapToVehicleDTO(Vehicle vehicle);
}