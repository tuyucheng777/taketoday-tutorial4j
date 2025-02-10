package cn.tuyucheng.taketoday.mapper;

import org.mapstruct.Mapper;

import cn.tuyucheng.taketoday.dto.SimpleSource;
import cn.tuyucheng.taketoday.entity.LombokDestination;
import cn.tuyucheng.taketoday.entity.SimpleDestination;

@Mapper
public interface LombokMapper {

   SimpleDestination sourceToDestination(SimpleSource source);

   LombokDestination sourceToLombokDestination(SimpleSource source);
}