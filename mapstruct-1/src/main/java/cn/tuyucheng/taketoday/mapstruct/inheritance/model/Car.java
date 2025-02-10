package cn.tuyucheng.taketoday.mapstruct.inheritance.model;

import cn.tuyucheng.taketoday.mapstruct.inheritance.model.dto.VehicleDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Car extends Vehicle {

   private Integer tires;

   @Override
   public VehicleDTO accept(Visitor visitor) {
      return visitor.visit(this);
   }
}