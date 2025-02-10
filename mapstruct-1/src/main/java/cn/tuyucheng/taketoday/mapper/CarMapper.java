package cn.tuyucheng.taketoday.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cn.tuyucheng.taketoday.dto.CarDTO;
import cn.tuyucheng.taketoday.entity.Car;

@Mapper
public interface CarMapper {

   CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

   CarDTO carToCarDTO(Car car);
}