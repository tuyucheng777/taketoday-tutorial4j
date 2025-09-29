package cn.tuyucheng.taketoday.dddhexagonalspring.infrastracture.configuration;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import cn.tuyucheng.taketoday.dddhexagonalspring.infrastracture.repository.mongo.SpringDataMongoOrderRepository;

@EnableMongoRepositories(basePackageClasses = SpringDataMongoOrderRepository.class)
public class MongoDBConfiguration {
}