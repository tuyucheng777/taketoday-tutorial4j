package cn.tuyucheng.taketoday.mapstruct.inheritance.mapper;

import org.mapstruct.Mapper;

import cn.tuyucheng.taketoday.mapstruct.inheritance.model.Bus;
import cn.tuyucheng.taketoday.mapstruct.inheritance.model.dto.BusDTO;

@Mapper()
public interface BusMapper {

   BusDTO busToDTO(Bus bus);
}