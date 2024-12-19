package cn.tuyucheng.taketoday.multiplecachemanager.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import cn.tuyucheng.taketoday.multiplecachemanager.entity.Order;
import cn.tuyucheng.taketoday.multiplecachemanager.repository.OrderDetailRepository;

@Component
public class OrderDetailBO {

   @Autowired
   private OrderDetailRepository orderDetailRepository;

   @Cacheable(cacheNames = "orders", cacheResolver = "cacheResolver")
   public Order getOrderDetail(Integer orderId) {
      return orderDetailRepository.getOrderDetail(orderId);
   }

   @Cacheable(cacheNames = "orderprice", cacheResolver = "cacheResolver")
   public double getOrderPrice(Integer orderId) {
      return orderDetailRepository.getOrderPrice(orderId);
   }
}