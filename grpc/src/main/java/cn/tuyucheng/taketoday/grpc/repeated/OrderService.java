package cn.tuyucheng.taketoday.grpc.repeated;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.grpc.stub.StreamObserver;

public class OrderService extends OrderServiceGrpc.OrderServiceImplBase {
   private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

   @Override
   public void createOrder(cn.tuyucheng.taketoday.grpc.repeated.UnpackedOrder unpackedOrder, StreamObserver<cn.tuyucheng.taketoday.grpc.repeated.UnpackedOrder> responseObserver) {
      List<Integer> productIds = unpackedOrder.getProductIdsList();
      if (validateProducts(productIds)) {
         int orderID = insertOrder(unpackedOrder);
         logger.info("Order {} created successfully", orderID);
         cn.tuyucheng.taketoday.grpc.repeated.UnpackedOrder createdUnpackedOrder = cn.tuyucheng.taketoday.grpc.repeated.UnpackedOrder.newBuilder(unpackedOrder)
               .setOrderId(orderID)
               .build();
         responseObserver.onNext(createdUnpackedOrder);
         responseObserver.onCompleted();
      }
   }

   private int insertOrder(cn.tuyucheng.taketoday.grpc.repeated.UnpackedOrder unpackedOrder) {
      return new Random().nextInt(100);
   }

   private boolean validateProducts(List<Integer> productIds) {
      return true;
   }
}