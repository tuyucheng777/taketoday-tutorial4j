package cn.tuyucheng.taketoday.mapstruct.inheritance;

import cn.tuyucheng.taketoday.mapstruct.inheritance.mapper.CarMapper;
import cn.tuyucheng.taketoday.mapstruct.inheritance.mapper.VehicleMapper;
import cn.tuyucheng.taketoday.mapstruct.inheritance.model.Car;
import cn.tuyucheng.taketoday.mapstruct.inheritance.model.dto.CarDTO;
import cn.tuyucheng.taketoday.mapstruct.inheritance.model.dto.VehicleDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static cn.tuyucheng.taketoday.mapstruct.inheritance.VehicleMapperTestUtil.getCarInstance;

public class VehicleMapperUnitTest {

   private final VehicleMapper vehicleMapper = Mappers.getMapper(VehicleMapper.class);

   private final CarMapper carMapper = Mappers.getMapper(CarMapper.class);

   @Test
   void whenVehicleTypeIsCar_thenBaseMapperNotMappingToSubclass() {
      Car car = getCarInstance();

      VehicleDTO vehicleDTO = vehicleMapper.vehicleToDTO(car);
      Assertions.assertFalse(vehicleDTO instanceof CarDTO);
      Assertions.assertInstanceOf(VehicleDTO.class, vehicleDTO);

      VehicleDTO carDTO = carMapper.carToDTO(car);
      Assertions.assertInstanceOf(CarDTO.class, carDTO);
   }
}