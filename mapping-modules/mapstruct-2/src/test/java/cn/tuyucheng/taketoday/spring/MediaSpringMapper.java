package cn.tuyucheng.taketoday.spring;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import cn.tuyucheng.taketoday.mapper.MediaMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MediaSpringMapper extends MediaMapper {
}