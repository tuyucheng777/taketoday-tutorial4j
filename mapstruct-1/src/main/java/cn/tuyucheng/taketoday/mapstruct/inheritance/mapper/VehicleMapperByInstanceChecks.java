package cn.tuyucheng.taketoday.mapstruct.inheritance.mapper;

import org.mapstruct.Mapper;

import cn.tuyucheng.taketoday.mapstruct.inheritance.model.Bus;
import cn.tuyucheng.taketoday.mapstruct.inheritance.model.dto.BusDTO;
import cn.tuyucheng.taketoday.mapstruct.inheritance.model.Car;
import cn.tuyucheng.taketoday.mapstruct.inheritance.model.dto.CarDTO;
import cn.tuyucheng.taketoday.mapstruct.inheritance.model.Vehicle;
import cn.tuyucheng.taketoday.mapstruct.inheritance.model.dto.VehicleDTO;

@Mapper()
public interface VehicleMapperByInstanceChecks {

   CarDTO map(Car car);

   BusDTO map(Bus bus);

   default VehicleDTO mapToVehicleDTO(Vehicle vehicle) {
      if (vehicle instanceof Bus) {
         return map((Bus) vehicle);
      } else if (vehicle instanceof Car) {
         return map((Car) vehicle);
      } else {
         return null;
      }
   }
}