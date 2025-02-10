package cn.tuyucheng.taketoday.mapstruct.inheritance.model;

import cn.tuyucheng.taketoday.mapstruct.inheritance.model.dto.VehicleDTO;

import lombok.Data;

@Data
public abstract class Vehicle {

   private String color;
   private String speed;

   public abstract VehicleDTO accept(Visitor visitor);
}