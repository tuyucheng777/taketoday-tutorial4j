package cn.tuyucheng.taketoday.hateoas.services;

import cn.tuyucheng.taketoday.hateoas.persistence.model.Order;

import java.util.List;

public interface OrderService {

   List<Order> getAllOrdersForCustomer(String customerId);

   Order getOrderByIdForCustomer(String customerId, String orderId);
}