package cn.tuyucheng.taketoday.mapstruct.inheritance;

import cn.tuyucheng.taketoday.mapstruct.inheritance.mapper.VehicleMapperBySubclassMapping;
import cn.tuyucheng.taketoday.mapstruct.inheritance.model.Bus;
import cn.tuyucheng.taketoday.mapstruct.inheritance.model.Car;
import cn.tuyucheng.taketoday.mapstruct.inheritance.model.dto.BusDTO;
import cn.tuyucheng.taketoday.mapstruct.inheritance.model.dto.CarDTO;
import cn.tuyucheng.taketoday.mapstruct.inheritance.model.dto.VehicleDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static cn.tuyucheng.taketoday.mapstruct.inheritance.VehicleMapperTestUtil.getBusInstance;
import static cn.tuyucheng.taketoday.mapstruct.inheritance.VehicleMapperTestUtil.getCarInstance;

public class VehicleMapperBySubclassMappingUnitTest {

   private final VehicleMapperBySubclassMapping vehicleMapper = Mappers.getMapper(VehicleMapperBySubclassMapping.class);

   @Test
   void whenVehicleTypeIsCar_thenMappedToCarDTOCorrectly() {
      Car car = getCarInstance();

      VehicleDTO vehicleDTO = vehicleMapper.mapToVehicleDTO(car);
      Assertions.assertInstanceOf(CarDTO.class, vehicleDTO);
      Assertions.assertEquals(car.getTires(), ((CarDTO) vehicleDTO).getTires());
      Assertions.assertEquals(car.getSpeed(), vehicleDTO.getSpeed());
      Assertions.assertEquals(car.getColor(), vehicleDTO.getColor());
   }

   @Test
   void whenVehicleTypeIsBus_thenMappedToBusDTOCorrectly() {
      Bus bus = getBusInstance();

      VehicleDTO vehicleDTO = vehicleMapper.mapToVehicleDTO(bus);
      Assertions.assertInstanceOf(BusDTO.class, vehicleDTO);
      Assertions.assertEquals(bus.getCapacity(), ((BusDTO) vehicleDTO).getCapacity());
      Assertions.assertEquals(bus.getSpeed(), vehicleDTO.getSpeed());
      Assertions.assertEquals(bus.getColor(), vehicleDTO.getColor());
   }
}