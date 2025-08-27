package cn.tuyucheng.taketoday.mapper;

import org.mapstruct.Mapper;

import cn.tuyucheng.taketoday.dto.MediaDto;
import cn.tuyucheng.taketoday.entity.Media;

@Mapper
public interface MediaMapper {

   MediaDto toDto(Media media);

   Media toEntity(MediaDto mediaDto);
}