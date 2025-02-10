package cn.tuyucheng.taketoday.mapstruct.date.mapper;

import cn.tuyucheng.taketoday.mapstruct.date.model.User;
import cn.tuyucheng.taketoday.mapstruct.date.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = DateMapper.class)
public interface UserConversionMapper {

   @Mapping(source = "birthDate", target = "birthDate")
   User toUser(UserDto userDto);
}