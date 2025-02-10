package cn.tuyucheng.taketoday.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import cn.tuyucheng.taketoday.dto.CustomerDto;
import cn.tuyucheng.taketoday.entity.Customer;

@Mapper
public interface CustomerDtoMapper {

   @Mapping(source = "firstName", target = "forename")
   @Mapping(source = "lastName", target = "surname")
   CustomerDto from(Customer customer);
}