package cn.tuyucheng.taketoday.ddd.order.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.tuyucheng.taketoday.ddd.order.Order;

public interface OrderMongoRepository extends MongoRepository<Order, String> {
}