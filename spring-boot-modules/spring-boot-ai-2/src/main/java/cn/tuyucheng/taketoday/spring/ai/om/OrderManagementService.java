package cn.tuyucheng.taketoday.spring.ai.om;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderManagementService {
   @Autowired
   private OrderRepository orderRepository;

   public Long createOrder(OrderInfo orderInfo) {
      return orderRepository.save(orderInfo).getOrderID();
   }

   public Optional<List<OrderInfo>> getAllUserOrders(String userID) {
      return orderRepository.findByUserID(userID);
   }
}