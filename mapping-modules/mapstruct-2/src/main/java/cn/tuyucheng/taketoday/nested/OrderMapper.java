package cn.tuyucheng.taketoday.nested;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import cn.tuyucheng.taketoday.nested.entity.Order;
import cn.tuyucheng.taketoday.nested.entity.OrderDto;

@Mapper
public interface OrderMapper {
   OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

   @Mapping(source = "customer.name", target = "customerName")
   @Mapping(source = "product.name", target = "productName")
   @Mapping(source = "product.price", target = "productPrice")
   @Mapping(source = "customer.address.city", target = "customerCity")
   @Mapping(expression = "java(order.getCustomer().getAddress().getZipCode())", target = "customerZipCode")
   OrderDto orderToOrderDto(Order order);
}