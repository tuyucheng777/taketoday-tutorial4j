package cn.tuyucheng.taketoday.mapstruct.inheritance.model;

import cn.tuyucheng.taketoday.mapstruct.inheritance.model.dto.VehicleDTO;

public interface Visitor {

   VehicleDTO visit(Car car);

   VehicleDTO visit(Bus bus);
}