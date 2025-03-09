package cn.tuyucheng.taketoday.list;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import cn.tuyucheng.taketoday.list.entity.Car;
import cn.tuyucheng.taketoday.list.entity.CarDto;

@Mapper
@DecoratedWith(CarMapperDecorator.class)
public interface CustomCarMapper {
   CustomCarMapper INSTANCE = Mappers.getMapper(CustomCarMapper.class);

   @Mapping(source = "seats", target = "numberOfSeats")
   CarDto carToCarDto(Car car);
}