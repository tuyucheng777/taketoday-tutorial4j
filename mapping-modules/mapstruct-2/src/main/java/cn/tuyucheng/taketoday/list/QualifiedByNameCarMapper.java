package cn.tuyucheng.taketoday.list;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import cn.tuyucheng.taketoday.list.entity.Car;
import cn.tuyucheng.taketoday.list.entity.CarDto;
import cn.tuyucheng.taketoday.list.entity.ManufacturingPlantDto;

@Mapper
public interface QualifiedByNameCarMapper {
   QualifiedByNameCarMapper INSTANCE = Mappers.getMapper(QualifiedByNameCarMapper.class);

   @Mapping(source = "seats", target = "numberOfSeats")
   @Mapping(target = "manufacturingPlantDtos", source = "car", qualifiedByName = "mapPlants")
   CarDto carToCarDto(Car car);

   @Named("mapPlants")
   default List<ManufacturingPlantDto> mapPlants(Car car) {
      return List.of(
            new ManufacturingPlantDto(car.getPlant1(), car.getPlant1Loc()),
            new ManufacturingPlantDto(car.getPlant2(), car.getPlant2Loc())
      );
   }
}