package cn.tuyucheng.taketoday.mapstruct.inheritance.mapper;

import org.mapstruct.Mapper;

import cn.tuyucheng.taketoday.mapstruct.inheritance.model.Car;
import cn.tuyucheng.taketoday.mapstruct.inheritance.model.dto.CarDTO;

@Mapper()
public interface CarMapper {

   CarDTO carToDTO(Car car);
}