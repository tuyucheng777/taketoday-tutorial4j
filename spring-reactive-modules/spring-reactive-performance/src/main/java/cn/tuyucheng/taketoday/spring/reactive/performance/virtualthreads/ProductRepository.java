package cn.tuyucheng.taketoday.spring.reactive.performance.virtualthreads;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.tuyucheng.taketoday.spring.reactive.performance.model.Product;

interface ProductRepository extends MongoRepository<Product, String> {
}