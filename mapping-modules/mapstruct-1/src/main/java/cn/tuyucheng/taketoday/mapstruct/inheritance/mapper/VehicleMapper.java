package cn.tuyucheng.taketoday.mapstruct.inheritance.mapper;

import org.mapstruct.Mapper;

import cn.tuyucheng.taketoday.mapstruct.inheritance.model.Vehicle;
import cn.tuyucheng.taketoday.mapstruct.inheritance.model.dto.VehicleDTO;

@Mapper(uses = {CarMapper.class, BusMapper.class})
public interface VehicleMapper {

   VehicleDTO vehicleToDTO(Vehicle vehicle);
}