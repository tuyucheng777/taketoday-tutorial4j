package cn.tuyucheng.taketoday.axon.querymodel;

import cn.tuyucheng.taketoday.axon.coreapi.queries.Order;

import java.util.Map;

import static cn.tuyucheng.taketoday.axon.querymodel.OrderStatusResponse.toResponse;

public class OrderResponse {

   private String orderId;
   private Map<String, Integer> products;
   private OrderStatusResponse orderStatus;

   OrderResponse(Order order) {
      this.orderId = order.getOrderId();
      this.products = order.getProducts();
      this.orderStatus = toResponse(order.getOrderStatus());
   }

   /**
    * Added for the integration test, since it's using Jackson for the response
    */
   OrderResponse() {
   }

   public String getOrderId() {
      return orderId;
   }

   public Map<String, Integer> getProducts() {
      return products;
   }

   public OrderStatusResponse getOrderStatus() {
      return orderStatus;
   }
}