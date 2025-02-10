package cn.tuyucheng.taketoday.mapstruct.date.mapper;

import cn.tuyucheng.taketoday.mapstruct.date.model.User;
import cn.tuyucheng.taketoday.mapstruct.date.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Mapper
public interface UserMapper {

   @Mapping(source = "birthDate", target = "birthDate", dateFormat = "yyyy-MM-dd")
   User toUser(UserDto userDto);

   @Mapping(target = "birthDate", expression = "java(mapStringToDate(userDto.getBirthDate()))")
   User toUserCustom(UserDto userDto) throws ParseException;

   default Date mapStringToDate(String date) throws ParseException {
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      return dateFormat.parse(date);
   }
}