package cn.tuyucheng.taketoday.testcontainers.repository;

import java.util.Optional;

import cn.tuyucheng.taketoday.testcontainers.model.Product;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    Optional<Product> findByName(String name);
}
